package ocp.ch5.i18n;

import static java.util.Arrays.asList;

import java.text.MessageFormat;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class JavaResourceBundle_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
				{"hello", "Hello"},
				{"by", "By"},
				{"test", asList("1", 4)},
				{"var", "Hi {0}"}
		};
	}

	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("ocp.ch5.i18n.JavaResourceBundle", Locale.ENGLISH);
		System.out.println(bundle.getString("by"));
		System.out.println(bundle.getObject("test"));
		System.out.println(MessageFormat.format(bundle.getString("var"), "John"));
	}

	// bundle search order for Locale("fr", "FR") if default is en_US
	// *_fr_FR.java
	// *_fr_FR.properties
	// *_fr.java
	// *_fr.properties
	// *_en_US.java
	// *_en_US.properties
	// *_en.java
	// *_en.properties
	// *.java
	// *.properties
	// MissingResourceException
}
