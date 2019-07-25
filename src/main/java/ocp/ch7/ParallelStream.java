package ocp.ch7;

import java.util.Arrays;

public class ParallelStream {

	public static void main(String[] args) {
		Arrays.asList(1, 2, 3, 4, 5, 6, 7).parallelStream().forEach(System.out::println); // e.g: 5 1 6 4 3 7 2
		System.out.println();
		Arrays.asList(1, 2, 3, 4, 5, 6, 7).parallelStream().forEachOrdered(System.out::println); // e.g: 1 2 3 4 5 6 7
	}
}
