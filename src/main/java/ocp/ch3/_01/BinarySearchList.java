package ocp.ch3._01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchList {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 9, 8, 6);
		Collections.sort(list);
		System.out.println(Collections.binarySearch(list, 6));

		// insertion point negated minus 1
		System.out.println(Collections.binarySearch(list, 3));
		System.out.println(Collections.binarySearch(list, 0));
		System.out.println(Collections.binarySearch(list, 10));
	}
}
