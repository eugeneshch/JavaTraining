package by.epam.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class MainStAX {

	public static void main(String[] args) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream("MyFirstLibrary.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			List<Book> books = process(reader);
			BookPrinter.print(books);
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	private static List<Book> process(XMLStreamReader reader) throws XMLStreamException {
		List<Book> bookList = new ArrayList<Book>();
		Book book = null;
		Reader bookReader = null;
		LibraryTagName elementName = null;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = LibraryTagName.valueOf(reader.getLocalName().toUpperCase());
				switch (elementName) {
				case BOOK:
					book = new Book();
					book.setId(Integer.parseInt(reader.getAttributeValue(null, "id")));
					break;
				case READER:
					bookReader = new Reader();
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
				case TITLE:
					book.setTitle(text);
					break;
				case AUTHOR:
					book.setAuthor(text);
					break;
				case YEAR:
					book.setYear(Integer.parseInt(text));
					break;
				case FNAME:
					bookReader.setFname(text);
					break;
				case LNAME:
					bookReader.setLname(text);
					break;
				case PHONE:
					bookReader.setPhone(text);
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				elementName = LibraryTagName.valueOf(reader.getLocalName().toUpperCase());
				switch (elementName) {
				case BOOK:
					bookList.add(book);
					book = null;
					break;
				case READER:
					book.addReader(bookReader);
					bookReader = null;
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		}
		return bookList;
	}
}
