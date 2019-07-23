package ocp.ch7;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConcurrentQAndDQ {

	public static void main(String[] args) {
		BlockingQueue<String> bq = new LinkedBlockingQueue<>();
		try {
			bq.offer("test", 1, TimeUnit.SECONDS);

			bq.poll(1, TimeUnit.SECONDS);

			BlockingDeque<String> bdq = new LinkedBlockingDeque<>();
			bdq.offerFirst("test", 1, TimeUnit.SECONDS);
			bdq.offerLast("test", 1, TimeUnit.SECONDS);
			bdq.pollFirst(1, TimeUnit.SECONDS);
			bdq.pollLast(1, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
