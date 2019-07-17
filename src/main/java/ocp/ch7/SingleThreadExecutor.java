package ocp.ch7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutor {

	public static void main(String[] args) {
		ExecutorService executorService = null;
		try {
			executorService = Executors.newSingleThreadExecutor();
			System.out.println("start");
			// order of execution = order of adding tasks
			executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " 1"));
			executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " 2"));
			executorService.execute(() -> {
				try {
					TimeUnit.SECONDS.sleep(3);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " 3");
			});
			System.out.println("end");
		} finally {
			executorService.shutdown();
			System.out.println("isShutDown: " + executorService.isShutdown());
			System.out.println("isTerminated: " + executorService.isTerminated());
			System.out.println("After shutdown");
//			executorService.shutdownNow(); // try to stop immediately
		}

		//start
		//pool-1-thread-1 1
		//pool-1-thread-1 2
		//end
		//isShutDown: true
		//isTerminated: false
		//After shutdown			!!!
		//pool-1-thread-1 3			!!!
	}
}
