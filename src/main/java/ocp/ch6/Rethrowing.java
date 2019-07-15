package ocp.ch6;

import java.io.IOException;
import java.sql.SQLException;

public class Rethrowing {

	public static void main(String[] args) throws IOException, SQLException {
		try {
			canThrow();
		}
		catch (Exception e) {
			throw e; // can be only IOException, SQLException
		}

		try {
			canThrow();
		}
		catch (IOException | SQLException e) {
//			e = new IOException(); // not allowed, e - is effectively final
			throw e; // can be only IOException, SQLException
		}
	}

	private static void canThrow() throws IOException, SQLException {

	}
}
