package ocp.ch3._01;

import java.util.Arrays;

public class BinarySearchArray {

	public static void main(String[] args) {
		int[] nums = { 1, 9, 6, 8 };
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.binarySearch(nums, 6));

		// insertion point negated minus 1
		System.out.println(Arrays.binarySearch(nums, 3));
		System.out.println(Arrays.binarySearch(nums, 0));
		System.out.println(Arrays.binarySearch(nums, 10));
	}
}
