package by.epam.xml;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class MainSAX {

	public static void main(String[] args) {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			LibrarySaxHandler handler = new LibrarySaxHandler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource("MyFirstLibrary.xml"));
			reader.setFeature("http://xml.org/sax/features/validation", true);
			reader.setFeature("http://xml.org/sax/features/string-interning", true);
			List<Book> books = handler.getBookList();
			BookPrinter.print(books);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}

	}

}
