package ocp.ch7;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWrite {

	public static void main(String[] args) {
		List<String> copyOnWrite = new CopyOnWriteArrayList<>(Arrays.asList("first", "second", "third"));

		for (String elem: copyOnWrite) {
			System.out.println(elem); // first, second, third
			copyOnWrite.add("other");
		}

		System.out.println(copyOnWrite.size()); // 6
	}
}
