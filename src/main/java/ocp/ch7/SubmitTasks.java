package ocp.ch7;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SubmitTasks {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executorService = null;
		try {
			executorService = Executors.newSingleThreadExecutor();
			Future<?> f = executorService.submit(() -> System.out.println("test"));
			Future<String> callable = executorService.submit(() -> "test");
			List<Future<String>> futures = executorService.invokeAll(asList(
					() -> "first",
					() -> "second"
			));
			List<Future<String>> futuresTimeout = executorService.invokeAll(asList(
					() -> "first",
					() -> "second"
			), 2, TimeUnit.SECONDS);
			String result = executorService.invokeAny(asList(
					() -> "first",
					() -> "second"
			));
			String resultTimeout = executorService.invokeAny(asList(
					() -> "first",
					() -> "second"
			), 2, TimeUnit.SECONDS);

			// result
			f.isDone();
			f.isCancelled();
			f.cancel(true);
			f.get();
			f.get(2, TimeUnit.SECONDS);
		} finally {
			if (executorService != null) {
				executorService.shutdown();
			}
		}

		if (executorService != null) {
			executorService.awaitTermination(1, TimeUnit.SECONDS);
			if (executorService.isTerminated()) {
				System.out.println("done");
			}
		}
	}
}
