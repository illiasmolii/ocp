package ocp.ch9;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest2 {

	public static void main(String[] args) {
		getName();

		getParent(Paths.get("src/main/resources/multiline.txt"));
		getParent(Paths.get("/home/dev/workspace/ocp/src/main/resources/multiline.txt"));

		sub();

		// should be both relative or both absolute (on win same disk)
		relativizeAbsolute();
		relativizeRelative();

		resolveAbsRelative();
		resolveAbsolutes();

		normalize();
	}

	private static void getName() {
		Path path = Paths.get("src/main/resources/multiline.txt");
		//		path.forEach(System.out::println);
		for (int i = 0; i< path.getNameCount(); i++) {
			System.out.println("Element: " + path.getName(i));
			// Element: src
			// Element: main
			// Element: resources
		}
		System.out.println();
	}

	private static void getParent(Path path) {
		System.out.println("File name: " + path.getFileName());

		boolean isAbsolute = path.isAbsolute();
		System.out.println("	" + (isAbsolute ? "Absolute path" : "Relative path"));
		if (!isAbsolute) {
			System.out.println("	Corresponding absolute path: " + path.toAbsolutePath());
		}
		System.out.println("	Root: " + path.getRoot()); // null for relative paths
		Path parent = path.getParent(); // for relative paths doesn't go to file system root
		System.out.println("	Parent: " + parent);
		if (parent != null) {
			getParent(parent);
		} else {
			System.out.println("		===== End =====" + System.lineSeparator());
		}
	}

	private static void sub() {
		Path relative = Paths.get("src/main/resources/multiline.txt");
		Path absolute = Paths.get("/home/dev/workspace/ocp/src/main/resources/multiline.txt");

		System.out.println(relative.subpath(0, 2)); // src/main
		System.out.println(relative.subpath(1, 3)); // main/resources

		System.out.println(absolute.subpath(0, 2)); // home/dev
		System.out.println();
	}

	private static void relativizeAbsolute() {
		Path absolute1 = Paths.get("/home/dev/workspace/ocp/src/main/resources/multiline.txt");
		Path absolute2 = Paths.get("/usr/bin/test");

		// go to root from resources
		System.out.println(absolute1.relativize(absolute2)); // ../../../../../../../../usr/bin/test

		// ../../../home/dev/workspace/ocp/src/main/resources/multiline.txt -
		// go to root from test first
		System.out.println(absolute2.relativize(absolute1));

		System.out.println();
	}

	private static void relativizeRelative() {
		Path relative2 = Paths.get("src/main/test.txt");
		Path relative1 = Paths.get("src/main/resources/multiline.txt");

		// go to common parent first
		System.out.println(relative1.relativize(relative2)); // ../../test.txt
		System.out.println(relative2.relativize(relative1)); // ../multiline.txt

		System.out.println();
	}

	private static void resolveAbsRelative() {
		Path path = Paths.get("/usr/bin/test");
		Path other = Paths.get("src/main/resources/multiline.txt");

		// /usr/bin/test/src/main/resources/multiline.txt
		// just append
		System.out.println(path.resolve(other));
	}

	private static void resolveAbsolutes() {
		Path path = Paths.get("/usr/bin/test");
		Path other = Paths.get("/usr/other/some");

		// /usr/other/some
		// just path from argument, abs2 in this case, abs1 is ignored
		System.out.println(path.resolve(other));
		System.out.println();
	}

	private static void normalize() {
		Path test = Paths.get("home/dir1/../dir2");

		System.out.println(test);
		System.out.println(test.normalize()); // home/dir2 removes redundant '..'
		System.out.println();
	}

	private static void realPath() {
		try {
			// checks if file exists, follow symlinks, calls normalize implicitly
			Path real = Paths.get("home/dir1/../dir2").toRealPath();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
