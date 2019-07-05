package ocp.ch4._02;

import java.util.Comparator;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		Stream.iterate(1, n -> n * 2)
				.limit(10)
				.min(Comparator.comparingInt(f -> f));

		System.out.println(Stream.of("a", "b", "c").reduce("", String::concat)); // abc
		System.out.println(Stream.of("a", "b", "c").reduce(String::concat)); 			// optional[abc]

		Stream.of(1, 2, 3).sorted(Comparator.reverseOrder());
	}
}
