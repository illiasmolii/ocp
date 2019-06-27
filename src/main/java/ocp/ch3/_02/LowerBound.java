package ocp.ch3._02;

import java.util.ArrayList;
import java.util.List;

public class LowerBound {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("test");
		List<Object> objects = new ArrayList<Object>(strings);
		test(strings);
		test(objects);
	}

	private static void test(List<? super String> list) {
		list.add("test2");
	}
}
