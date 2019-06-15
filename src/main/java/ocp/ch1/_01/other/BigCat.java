package ocp.ch1._01.other;

import ocp.ch1._01.Cat;

public class BigCat extends Cat {

	public static void main(String[] args) {
		Cat cat = new Cat();
		String publicString = cat.publicString;
//		String protectedString = cat.protectedString; // as accessed not through subclass
//		String defaultString = cat.defaultString;
//		String privateString = cat.privateString;

		BigCat bigCat = new BigCat();
		String publicStringB = bigCat.publicString;
		String protectedStringB = bigCat.protectedString;
//		String defaultStringB = bigCat.defaultString;
//		String privateStringB = bigCat.privateString;
	}
}
