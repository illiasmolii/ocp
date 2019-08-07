package ocp.ch8;

import java.io.Console;

public class ConsoleTest {

	public static void main(String[] args) {
		Console console = System.console();
		if (console != null) {
			String input = console.readLine();
			console.writer().println("Input is: " + input);
		} else {
			System.err.println("No console");
		}
	}
}
