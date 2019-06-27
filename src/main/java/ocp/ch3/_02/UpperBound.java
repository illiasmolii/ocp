package ocp.ch3._02;

import java.util.ArrayList;
import java.util.List;

public class UpperBound {

	static class Parent {}
	static class Child extends Parent {}
	static class Child2 extends Parent {}

	public static void main(String[] args) {
		List<? extends Parent> parentList = new ArrayList<Child2>();
//		parentList.add(new Parent()); as might be a List<Child> or List<Child2>
//		parentList.add(new Child()); as might be a List<Child2>
//		parentList.add(new Object()); unbounded & upper-bounded lists are 'immutable'

		List<Parent> withoutBound = new ArrayList<>();
		withoutBound.add(new Child());
	}
}
