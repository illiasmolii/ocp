package ocp.ch3._04;

import java.util.Comparator;

public class ComparatorTest {

	static class Test {
		int i;
		String s;

		public Test(int i, String s) {
			this.i = i;
			this.s = s;
		}

		public int getI() {
			return i;
		}

		public String getS() {
			return s;
		}
	}

	public static void main(String[] args) {
		Comparator<Test> comparator =
				Comparator
						.comparing(Test::getS)
						.thenComparingInt(Test::getI);
		System.out.println(
				comparator.compare(new Test(3, "test"), new Test(2, "test"))
		);
	}
}
