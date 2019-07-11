package ocp.ch5.i18n;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties properties = new Properties();
		ResourceBundle bundle = ResourceBundle.getBundle("test", Locale.ENGLISH);
		bundle.keySet().forEach(k -> properties.put(k, bundle.getString(k)));

		System.out.println(properties.get("hello"));  										// Hello
		System.out.println(properties.get("missing")); 										// null
		System.out.println(properties.getProperty("missing")); 								// null
		System.out.println(properties.getProperty("missing", "default")); 	// default
		System.out.println(properties.getProperty("hello", "default"));		// Hello
		System.out.println(properties.getProperty("hello")); 								// Hello
	}
}
