package ocp.ch3._05;

import java.util.HashMap;
import java.util.Map;

public class NewMapMethods {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("test", 1);
		map.put("test2", null);
		map.putIfAbsent("test", 2);
		map.putIfAbsent("test2", 2); // [test -> 1, test2 -> 2]
		System.out.println(map);

		map.merge("test", 3, Integer::sum); // [test -> 4, test2 -> 2]
		System.out.println(map);

		map.merge("test2", 4, (oldV, newV) -> null); // [test -> 4]
		System.out.println(map);

		map.computeIfPresent("test", (k, v) -> v + k.length());
		System.out.println(map); // [test -> 8]

		map.computeIfAbsent("test3", String::length);
		System.out.println(map); // [test -> 8, test3 -> 5]
	}
}
