package ocp.ch7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CyclicBarrierTest {

	static class Worker {

		private void task(int id) {
			System.out.println("Task '" + id + "'. Worker: " + getWorkerId());
		}

		private String getWorkerId() {
			return Thread.currentThread().getName();
		}

		void doWork(CyclicBarrier first, CyclicBarrier second) {
			try {
				task(1);
				first.await();
				task(2);
				second.await();
				task(3);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		int numberOfWorkers = 3;
		CyclicBarrier first = new CyclicBarrier(numberOfWorkers, () -> System.out.println("!!! first finished"));
		CyclicBarrier second = new CyclicBarrier(numberOfWorkers, () -> System.out.println("!!! second finished"));
		ExecutorService pool = Executors.newFixedThreadPool(numberOfWorkers);
		IntStream.rangeClosed(1, numberOfWorkers).forEach(id -> pool.submit(() -> new Worker().doWork(first, second)));
	}

	// Task '1'. Worker: pool-1-thread-3
	// Task '1'. Worker: pool-1-thread-2
	// Task '1'. Worker: pool-1-thread-1
	// !!! first finished
	// Task '2'. Worker: pool-1-thread-1
	// Task '2'. Worker: pool-1-thread-3
	// Task '2'. Worker: pool-1-thread-2
	// !!! second finished
	// Task '3'. Worker: pool-1-thread-2
	// Task '3'. Worker: pool-1-thread-1
	// Task '3'. Worker: pool-1-thread-3
}
