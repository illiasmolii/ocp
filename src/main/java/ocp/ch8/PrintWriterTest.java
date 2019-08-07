package ocp.ch8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterTest {

	static class Dto {

		private int i;
		private String s;

		public Dto(int i, String s) {
			this.i = i;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Dto{" +
					"i=" + i +
					", s='" + s + '\'' +
					'}';
		}
	}

	public static void main(String[] args) throws IOException {
		try (PrintWriter writer =
				new PrintWriter(new BufferedWriter(new FileWriter(new File("src/main/resources/print_writer.txt"))))) {
			writer.println(new Dto(1, "first"));
			writer.println();
			writer.println("hello");
			writer.println();
			writer.println(new Dto(2, "second"));
		}
	}
}
