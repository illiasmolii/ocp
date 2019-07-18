package ocp.ch7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class RaceCondition {

	private static int counter = 0;

	private static void increment() {
		counter++;
		System.out.println(counter);
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(20);
		IntStream.range(0, 10).forEach(index -> executor.submit(RaceCondition::increment));
		executor.shutdown();
		// Possible outputs
		// 2		2		2
		// 4		3		2
		// 2		2		3
		// 3		4		5
		// 5		5		4
		// 6		6		6
		// 7		7		7
		// 8		8		8
		// 9		9		9
		// 10		10		10
	}
}
