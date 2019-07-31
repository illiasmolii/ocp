package ocp.ch8;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileTest2 {

	public static void main(String[] args) {
		printContent(new File("/home/dev/Pictures"));
	}

	private static void printContent(File file) {
		if (file.exists()) {
			if (file.isDirectory()) {
				System.out.println("Dir: " + file.getAbsolutePath());
				File[] content = file.listFiles();
				System.out.println("	Content: " + Arrays.stream(content).map(File::getName).collect(Collectors.joining("\n			")));
				Arrays.stream(content).forEach(FileTest2::printContent);
			} else {
				System.out.println("File: " + file.getAbsolutePath());
				System.out.println("	Size: " + file.length());
				System.out.println("	Modified: " + LocalDateTime.ofEpochSecond(file.lastModified() / 1000, 0, ZoneOffset.UTC));
			}
			System.out.println("===========================================");
		}
	}
}
