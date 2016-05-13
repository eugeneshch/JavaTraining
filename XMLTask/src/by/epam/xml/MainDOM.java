package by.epam.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MainDOM {

	public static void main(String[] args) {
		DOMParser parser = new DOMParser();
		try {
			parser.parse("MyFirstLibrary.xml");
			Document document = parser.getDocument();
			Element root = document.getDocumentElement();
			List<Book> bookList = new ArrayList<Book>();
			NodeList bookNodes = root.getElementsByTagName("book");
			Book book = null;
			NodeList readers = null;
			Reader bookReader = null;
			for (int i = 0; i < bookNodes.getLength(); i++) {
				book = new Book();
				Element bookElement = (Element) bookNodes.item(i);
				book.setId(Integer.parseInt(bookElement.getAttribute("id")));
				book.setTitle(getSingleChildText(bookElement, "title"));
				book.setAuthor(getSingleChildText(bookElement, "author"));
				book.setYear(Integer.parseInt(getSingleChildText(bookElement, "year")));
				readers = bookElement.getElementsByTagName("reader");
				for (int j = 0; j < readers.getLength(); j++) {
					bookReader = new Reader();
					Element readerElement = (Element) readers.item(j);
					bookReader.setFname(getSingleChildText(readerElement, "fname"));
					bookReader.setLname(getSingleChildText(readerElement, "lname"));
					bookReader.setPhone(getSingleChildText(readerElement, "phone"));
					book.addReader(bookReader);
				}
				bookList.add(book);
			}
			BookPrinter.print(bookList);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		

	}

	private static String getSingleChildText(Element element, String childName) {
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child.getTextContent().trim();
	}

}
