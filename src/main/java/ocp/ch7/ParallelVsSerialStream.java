package ocp.ch7;

import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class ParallelVsSerialStream {

	public static void main(String[] args) {
		long startSerial = System.currentTimeMillis();
		IntStream.range(0, 1000).forEach(getTask());
		System.out.println("Serial: " + ((System.currentTimeMillis() - startSerial) / 1000.0)); // ~ 10.144s

		long startParallel = System.currentTimeMillis();
		IntStream.range(0, 1000).parallel()
//				.peek(i -> System.out.println(Thread.currentThread().getName())) // ForkJoinPool.commonPool-worker-N
				.forEach(getTask());
		System.out.println("Parallel: " + ((System.currentTimeMillis() - startParallel) / 1000.0)); // ~ 1.275s for 8-core CPU
	}

	private static IntConsumer getTask() {
		return e -> {
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		};
	}
}
