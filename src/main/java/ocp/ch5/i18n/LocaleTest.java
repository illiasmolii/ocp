package ocp.ch5.i18n;

import java.util.Locale;

public class LocaleTest {

	public static void main(String[] args) {
		System.out.println(Locale.getDefault());
		System.out.println(new Locale("ru", "UA"));
		System.out.println(new Locale.Builder().setRegion("UA").setLanguage("ru").build());

		Locale.setDefault(new Locale("no"));
		System.out.println(Locale.getDefault());
	}
}
