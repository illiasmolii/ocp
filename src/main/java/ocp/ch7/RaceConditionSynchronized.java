package ocp.ch7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class RaceConditionSynchronized {

	private int counter = 0;

	private void increment() {
		synchronized (this) {
			counter++;
		}
		System.out.println(counter);
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(20);
		RaceConditionSynchronized raceConditionSynchronized = new RaceConditionSynchronized();
		IntStream.range(0, 10).forEach(index -> executor.submit(raceConditionSynchronized::increment));
		executor.shutdown();
		// Output
		// 1
		// 2
		// 3
		// 4
		// 5
		// 6
		// 7
		// 8
		// 9
		// 10
	}
}
