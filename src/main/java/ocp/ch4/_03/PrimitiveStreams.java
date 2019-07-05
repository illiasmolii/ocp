package ocp.ch4._03;

import java.util.stream.Stream;

public class PrimitiveStreams {

	public static void main(String[] args) {
		System.out.println(
				Stream.of(1, 2, 3)
						.mapToInt(x -> x)
						.average()
						.getAsDouble()
		);

		System.out.println(
				Stream.of(1, 2, 3)
						.mapToInt(x -> x)
						.summaryStatistics()
						.getMin()
		);
	}
}
