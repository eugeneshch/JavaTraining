package by.epam.xml;

import java.util.List;

public class BookPrinter {
	public static void print(List<Book> books) {
		for (Book book : books) {
			System.out.println("id = " + book.getId() + "\nTitle: " + book.getTitle() + "\nAuthor: "
					+ book.getAuthor() + "\nYear: " + book.getYear() + "\nReaders:");
			for (Reader bookReader : book.getReaders()) {
				System.out.println(bookReader.getFname() + " " + bookReader.getLname()
						+ " " + bookReader.getPhone());
			}
		}
	}
}
