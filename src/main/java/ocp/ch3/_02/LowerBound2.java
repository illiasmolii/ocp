package ocp.ch3._02;

import java.util.ArrayList;
import java.util.List;

public class LowerBound2 {

	public static void main(String[] args) {
		List<? super RuntimeException> ex = new ArrayList<>();
		ex.add(new RuntimeException());
		ex.add(new IndexOutOfBoundsException());
//		ex.add(new Exception()); as ex might be a List<RuntimeException>
		//		which is not applicable for Exception
	}
}
