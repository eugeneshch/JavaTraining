package by.epam.xml;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private int id;
	private String title;
	private String author;
	private int year;
	private List<Reader> readers = new ArrayList<Reader>();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public List<Reader> getReaders() {
		return readers;
	}
	
	public void setReaders(List<Reader> readers) {
		this.readers = readers;
	}
	
	public void addReader(Reader reader) {
		readers.add(reader);
	}
}
