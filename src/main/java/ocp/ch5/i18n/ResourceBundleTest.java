package ocp.ch5.i18n;

import static java.util.stream.Collectors.toList;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

	public static void main(String[] args) {
		ResourceBundle it = ResourceBundle.getBundle("test", Locale.ITALIAN);
		ResourceBundle en = ResourceBundle.getBundle("test", Locale.ENGLISH);
		ResourceBundle ruUa = ResourceBundle.getBundle("test", new Locale("ru", "UA"));
		System.out.println(it.getString("hello"));
		System.out.println(en.getString("hello"));
		System.out.println(ruUa.getString("hello"));

		System.out.println(en.keySet().stream().map(k -> k + " -> " + en.getString(k)).collect(toList()));
	}
}
