package ocp.ch8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {

	public static void main(String[] args) throws IOException {
		File from = new File("src/main/resources/test.txt");
		File to = new File("src/main/resources/test_copy.txt");
		copy(from, to);
	}

	static void copy(File from, File to) throws IOException {
		try(InputStream in = new BufferedInputStream(new FileInputStream(from));
				OutputStream out = new BufferedOutputStream(new FileOutputStream(to))) {
			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
				out.flush();
			}
		}
	}
}
