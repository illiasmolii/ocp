package ocp.ch4._04;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredefinedCollectors {

	public static void main(String[] args) {
		System.out.println(
				Stream.of("f", "se", "thi")
						.collect(Collectors.averagingInt(String::length)) // 2.0
		);

		System.out.println(
				Stream.of("f", "se", "thi")
						.collect(Collectors.summingInt(String::length)) // 6
		);

		System.out.println(
				Stream.of("f", "se", "thi").count() // same as below
//				Stream.of("f", "se", "thi").collect(Collectors.counting())
		);

		System.out.println(
				Stream.of("1", "22", "333", "22")
						.collect(Collectors.groupingBy(String::length)) // {1=[1], 2=[22, 22], 3=[333]}
		);

		System.out.println(
				Stream.of("1", "22", "333", "22")
						.collect(Collectors.joining("_")) // 1_22_333_22
		);

		System.out.println(
				Stream.of("a", "ba", "bb")
						.collect(Collectors.partitioningBy(s -> s.contains("a"))) // {false=[bb], true=[a, ba]}
		);

		Map<Integer, String> collect = Stream.of("a", "aa", "aaa", "bb")
				.collect(
						Collectors.toMap(
								String::length,
								Function.identity(),
								String::concat,
								TreeMap::new
						)
				);
		System.out.println(collect); // {1=a, 2=aabb, 3=aaa}
	}
}
