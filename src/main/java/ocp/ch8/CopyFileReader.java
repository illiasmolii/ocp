package ocp.ch8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileReader {

	public static void main(String[] args) throws IOException {
		File from = new File("src/main/resources/multiline.txt");
		File to = new File("src/main/resources/COPY_multiline.txt");
		copy(from, to);
	}

	private static void copy(File from, File to) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(from));
				BufferedWriter writer = new BufferedWriter(new FileWriter(to))) {
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}
		}
	}
}
