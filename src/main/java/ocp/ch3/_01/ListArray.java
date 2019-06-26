package ocp.ch3._01;

import java.util.Arrays;
import java.util.List;

public class ListArray {

	public static void main(String[] args) {
		String[] arr = { "first", "second" };
		List<String> list = Arrays.asList(arr);
		System.out.println(list);
		arr[0] = "changed_first";
		System.out.println(list);
	}
}
