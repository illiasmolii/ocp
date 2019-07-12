package ocp.ch5.i18n;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Formatting {

	public static void main(String[] args) throws ParseException {
		currency(Locale.GERMAN);
		currency(Locale.CANADA_FRENCH);
		currency(Locale.US);
		currency(new Locale("ru_UA"));

		System.out.println(NumberFormat.getInstance(Locale.US).parse("40.45"));		// 40.45
		System.out.println(NumberFormat.getInstance(Locale.FRANCE).parse("40.45"));	// 40
	}

	private static void currency(Locale locale) {
		System.out.println(
				NumberFormat.getCurrencyInstance(locale).format(45.2)
		);
	}
}
