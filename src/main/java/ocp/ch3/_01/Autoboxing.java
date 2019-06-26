package ocp.ch3._01;

import java.util.ArrayList;
import java.util.List;

public class Autoboxing {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(new Integer(3));
		numbers.add(new Integer(5));
		numbers.remove(1); // calls -> E remove(int index); no autobixing
		numbers.remove(new Integer(5)); // calls -> boolean remove(Object o); no need to box anything
		System.out.println(numbers); // [1]
	}
}
