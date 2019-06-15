package ocp.ch1._02;

import java.util.ArrayList;
import java.util.Map;

public class Test2 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		System.out.println(list instanceof ArrayList);
//		System.out.println(list instanceof String); // arrayList never will be a String

		// fine because Map is an interface, despite that AL is not implementing Map
		// The reason is that a subclass could implement that interface and the compiler
		// wouldn’t know it:
		// class NewArrayList extends ArrayList implements Map {}
		// for classes it's not possible as class could extend only on class
		System.out.println(list instanceof Map);
	}
}
