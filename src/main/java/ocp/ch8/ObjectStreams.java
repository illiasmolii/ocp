package ocp.ch8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStreams {

	static class A implements Serializable {

		private static final long serialVersionUID = 5229537908699913753L;

		private int i;
		private String s;

		public A(int i, String s) {
			this.i = i;
			this.s = s;
		}

		@Override
		public String toString() {
			return "A{" +
					"i=" + i +
					", s='" + s + '\'' +
					'}';
		}
	}

	static class B implements Serializable {

		private static final long serialVersionUID = -1307660791386521725L;

		private int i;

		public B(int i) {
			this.i = i;
		}

		@Override
		public String toString() {
			return "B{" +
					"i=" + i +
					'}';
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file = new File("src/main/resources/objects");
		write(file);
		read(file);
	}

	static void write(File to) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(to)))) {
			out.writeObject(new A(1, "first"));
			out.writeObject(new B(2));
			out.writeObject(new A(3, "second"));
		}
	}

	static void read(File from) throws IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(from)))) {
			while (true) {
				Object object = in.readObject();
				if (object instanceof A) {
					System.out.println((A) object);
				} else if (object instanceof B) {
					System.out.println((B) object);
				} else {
					System.out.println("Unknown type");
				}
			}
		} catch (EOFException e) {
			System.out.println("=== DONE ===");
		}
	}
}
