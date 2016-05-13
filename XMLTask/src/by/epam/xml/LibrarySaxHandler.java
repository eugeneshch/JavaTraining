package by.epam.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class LibrarySaxHandler extends DefaultHandler {
	private List<Book> bookList = new ArrayList<Book>();
	private Book book;
	private Reader reader;
	private StringBuilder text;
	
	public List<Book> getBookList() {
		return bookList;
	}
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Parsing started.");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
	}

	@Override
	public void startElement(String uri, String localName, String qName, 
								Attributes attributes) throws SAXException {
		text = new StringBuilder();
		if (localName.equals("book")) {
			book = new Book();
			book.setId(Integer.parseInt(attributes.getValue("id")));
		}
		if (localName.equals("reader")) {
			reader = new Reader();
		}
	}

	@Override
	public void characters(char[] buffer, int start, int length) throws SAXException {
		text.append(buffer, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		LibraryTagName tagName = LibraryTagName.valueOf(localName.toUpperCase());
		switch (tagName) {
		case TITLE:
			book.setTitle(text.toString());
			break;
		case AUTHOR:
			book.setAuthor(text.toString());
			break;
		case YEAR:
			book.setYear(Integer.parseInt(text.toString()));
			break;
		case BOOK:
			bookList.add(book);
			book = null;
			break;
		case FNAME:
			reader.setFname(text.toString());
			break;
		case LNAME:
			reader.setLname(text.toString());
			break;
		case PHONE:
			reader.setPhone(text.toString());
			break;
		case READER:
			book.addReader(reader);
			reader = null;
			break;
		default:
			break;
		}
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		System.out.println("ERROR: line " + exception.getLineNumber() + ": "
				+ exception.getMessage());
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("FATAL: line " + exception.getLineNumber() + ": "
				+ exception.getMessage());
	}

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		System.out.println("WARNING: line " + exception.getLineNumber() + ": "
						+ exception.getMessage());
	}
}
