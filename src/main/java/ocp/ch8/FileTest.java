package ocp.ch8;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		System.out.println(System.getProperty("file.separator"));
		System.out.println(File.separator);

		System.out.println(new File("/home").exists());

		File parent = new File("/home");
		File child = new File(parent, "user");
		System.out.println(child.lastModified());

		new File("/home/newDir/childDir").mkdirs(); // create all dirs in path
		System.out.println(parent.listFiles());
	}
}
