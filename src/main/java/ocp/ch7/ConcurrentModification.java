package ocp.ch7;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModification {

	public static void main(String[] args) {
		concurrent();
		regular();
	}

	private static void concurrent() {
		Map<String, String> cMap = new ConcurrentHashMap<>();
		cMap.put("a", "a");
		cMap.put("b", "b");

		for (String k: cMap.keySet()) {
			cMap.remove(k);
		}
	}

	private static void regular() {
		Map<String, String> hMap = new HashMap<>();
		hMap.put("a", "a");
		hMap.put("b", "b");

		for (String k: hMap.keySet()) {
			hMap.remove(k); // ConcurrentModificationException
		}
	}
}
