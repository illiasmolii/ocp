package ocp.ch6;

import java.util.Arrays;

public class SuppressedExceptions {

	static class TestAutoClosable implements AutoCloseable {

		private final Integer id;

		public TestAutoClosable(Integer id) {
			this.id = id;
		}

		@Override
		public void close() {
			throw new IllegalStateException("Close: " + this.id);
		}
	}

	public static void main(String[] args) {
		try (TestAutoClosable ignored = new TestAutoClosable(1);
				TestAutoClosable ignored1 = new TestAutoClosable(2)) {
			throw new IllegalStateException("From try");
		}
		catch (IllegalStateException e) {
			System.out.println("Caught: " + e.getMessage());
			Arrays.stream(e.getSuppressed()).forEach(System.out::println);
			// Caught: From try
			// java.lang.IllegalStateException: Close: 2
			// java.lang.IllegalStateException: Close: 1
		}
	}
}
