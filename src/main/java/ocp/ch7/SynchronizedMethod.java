package ocp.ch7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SynchronizedMethod {

	private int counter = 0;

	private synchronized void increment() { //equivalent to synchronized(this) {}
		counter++;
		System.out.println(counter);
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(20);
		SynchronizedMethod synchronizedMethod = new SynchronizedMethod();
		IntStream.range(0, 10).forEach(index -> executor.submit(synchronizedMethod::increment));
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
