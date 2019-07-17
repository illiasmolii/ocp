package ocp.ch7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Scheduling {

	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutor.schedule(() -> System.out.println("hi"), 1, TimeUnit.SECONDS); // hi after 1 sec

		// hi each 2 sec with delay of 1 sec
		ScheduledFuture<?> future = scheduledExecutor.scheduleAtFixedRate(
				() -> System.out.println("hi"),
				1,
				2,
				TimeUnit.SECONDS
		);
		System.out.println(future.getDelay(TimeUnit.SECONDS));

		// if 1st task continues 5 minutes, 2nd will start from the minute 8 (1m initial delay + 5m task + 2m delay)
		ScheduledFuture<?> delay = scheduledExecutor.scheduleWithFixedDelay(
				() -> System.out.println("hi"),
				1,
				2,
				TimeUnit.MINUTES
		);
	}
}
