package ocp.ch7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Atomic {

	private static AtomicInteger counter = new AtomicInteger(0);

	private static void increment() {
		int value = counter.incrementAndGet();
		System.out.println(value);
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(20);
		IntStream.range(0, 10).forEach(index -> executor.submit(Atomic::increment));
		executor.shutdown();
		// Possible outputs (always 1-10)
		// 1		2		1
		// 3		4		2
		// 2		3		3
		// 4		1		4
		// 5		6		5
		// 6		5		6
		// 7		7		7
		// 8		8		8
		// 9		9		9
		// 10		10		10
	}
}
