package ocp.ch7;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinRecursiveAction {

	static class Action extends RecursiveAction {
		private final static int MAX = 2;
		private int start;
		private int end;
		private int[] toCompute;

		public Action(int start, int end, int[] toCompute) {
			this.start = start;
			this.end = end;
			this.toCompute = toCompute;
		}

		@Override
		protected void compute() {
			if (end - start <= MAX) {
				for (int i = start; i < end; i++) {
					int value = new Random().nextInt(100);
					toCompute[i] = value;
					System.out.println(Thread.currentThread().getName() + " computed value " + value);
				}
			}
			else {
				int middle = start + ((end - start) / 2);
				invokeAll(
						new Action(start, middle, toCompute),
						new Action(middle, end, toCompute)
				);
			}
		}
	}

	public static void main(String[] args) {
		int size = 10;
		int[] toCompute = new int[size];
		ForkJoinTask<?> task = new Action(0, size, toCompute);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);

		System.out.println(Arrays.toString(toCompute));
	}

	// ForkJoinPool-1-worker-1 computed value 53
	// ForkJoinPool-1-worker-1 computed value 79
	// ForkJoinPool-1-worker-1 computed value 47
	// ForkJoinPool-1-worker-1 computed value 22
	// ForkJoinPool-1-worker-2 computed value 84
	// ForkJoinPool-1-worker-2 computed value 39
	// ForkJoinPool-1-worker-5 computed value 74
	// ForkJoinPool-1-worker-5 computed value 68
	// ForkJoinPool-1-worker-2 computed value 26
	// ForkJoinPool-1-worker-3 computed value 58
	// [53, 79, 58, 47, 22, 84, 39, 26, 74, 68]
}
