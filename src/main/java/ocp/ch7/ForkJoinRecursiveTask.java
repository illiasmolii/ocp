package ocp.ch7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinRecursiveTask {

	static class Task extends RecursiveTask<Integer> {
		private final static int MAX = 2;
		private int start;
		private int end;
		private int[] toCompute;

		public Task(int start, int end, int[] toCompute) {
			this.start = start;
			this.end = end;
			this.toCompute = toCompute;
		}

		@Override
		protected Integer compute() {
			if (end - start <= MAX) {
				int sum = 0;
				for (int i = start; i < end; i++) {
					sum += toCompute[i];
					System.out.println(Thread.currentThread().getName() + " current sum: " + sum);
				}
				return sum;
			} else {
				int middle = start + ((end - start) / 2);
				Task left = new Task(start, middle, toCompute);
				left.fork();

				Task right = new Task(middle, end, toCompute);

				Integer rightResult = left.join();
				Integer leftResult = right.compute();

				return leftResult + rightResult;
			}
		}
	}

	public static void main(String[] args) {
		int[] toCompute = { 1, 3, 945, 3, 6754, 5, 8, 10, 543, 23 };
		ForkJoinTask<Integer> task = new Task(0, toCompute.length, toCompute);
		ForkJoinPool pool = new ForkJoinPool();
		Integer result = pool.invoke(task);
		System.out.println(result);
	}

	// ForkJoinPool-1-worker-2 current sum: 1
	// ForkJoinPool-1-worker-2 current sum: 4
	// ForkJoinPool-1-worker-1 current sum: 945
	// ForkJoinPool-1-worker-1 current sum: 3
	// ForkJoinPool-1-worker-1 current sum: 6757
	// ForkJoinPool-1-worker-1 current sum: 5
	// ForkJoinPool-1-worker-1 current sum: 13
	// ForkJoinPool-1-worker-1 current sum: 10
	// ForkJoinPool-1-worker-1 current sum: 543
	// ForkJoinPool-1-worker-1 current sum: 566
	// 8295
}
