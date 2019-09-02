package ocp.ch4._04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test3Q58 {

	private static class Book {
		private int id;
		private String genre;
		private String author;

		public Book(int id, String genre, String author) {
			this.id = id;
			this.genre = genre;
			this.author = author;
		}

		public int getId() {
			return id;
		}

		public String getGenre() {
			return genre;
		}

		public String getAuthor() {
			return author;
		}

		@Override
		public String toString() {
			return String.valueOf(id);
		}
	}

	public static void main(String[] args) {
		List<Book> books = Arrays.asList(
				new Book(1, "Horror", "John"),
				new Book(2, "Horror", "Ann"),
				new Book(3, "Horror", "Ann"),
				new Book(4, "Fantasy", "John")
		);
		System.out.println(
				books.stream().collect(Collectors.groupingBy(Book::getGenre, Collectors.groupingBy(Book::getAuthor)))
		);

		System.out.println(
				books.stream().collect(Collectors.groupingBy(Book::getGenre, Collectors.mapping(Book::getAuthor, Collectors.toList())))
		);
	}
}
