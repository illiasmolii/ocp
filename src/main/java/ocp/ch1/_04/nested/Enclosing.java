package ocp.ch1._04.nested;

public class Enclosing {

	public static class Nested {
		private int privateVar = 12;
	}

	public static void main(String[] args) {
		System.out.println(new Nested().privateVar);
	}
}
