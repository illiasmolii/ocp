package ocp.ch4._01;

import java.util.function.Predicate;

public class PredicateUsage {

	public static void main(String[] args) {
		Predicate<String> start = s -> s.startsWith("Prefix");
		Predicate<String> end = s -> s.endsWith("sufix");

		Predicate<String> combined = start.and(end.negate());

		System.out.println(combined.test("Prefix!!suFix"));
	}
}
