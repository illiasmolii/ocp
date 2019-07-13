package ocp.ch5.i18n;

import java.text.NumberFormat;
import java.text.ParseException;

public class NumberFormatParse {

	public static void main(String[] args) throws ParseException {
		NumberFormat numberFormat = NumberFormat.getInstance();
		System.out.println(numberFormat.parse("1234aasd"));	// 1234
		System.out.println(numberFormat.parse("-1.234fsd"));// -1.234
//		System.out.println(numberFormat.parse("f234"));		// ParseException

		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		System.out.println(currencyFormat.parse("$324,344.43"));
	}
}
