package ocp.ch7;

import java.util.stream.IntStream;

public class ParallelReduction {

	public static void main(String[] args) {
		String result = IntStream.range(1, 10).mapToObj(Integer::toString)
				.parallel()
				.reduce("", (a, b) -> a + b, (a, b) -> a + b); // accumulator & combiner are associative
		System.out.println(result); // 123456789
	}
}
