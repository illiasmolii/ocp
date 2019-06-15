package ocp.ch1._04;

public class Outer {

	private String str = "outer.test";

	public class Inner {

		private String str = "inner.test";

		void print() {
			System.out.println(this.str); // inner.test
			System.out.println(Outer.this.str); // outer.test
		}
	}

	void test() {
		new Inner().print();
	}

	public static void main(String[] args) {
		new Outer().test();
		new Outer().new Inner().print();
	}
}
