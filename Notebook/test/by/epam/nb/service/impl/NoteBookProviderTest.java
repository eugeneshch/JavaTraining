package by.epam.nb.service.impl;

import org.testng.annotations.Test;

import by.epam.nb.bean.Note;
import by.epam.nb.bean.NoteBook;
import by.epam.nb.service.ProviderService;
import by.epam.nb.service.ServiceFactory;

import java.util.List;

import org.testng.Assert;

public class NoteBookProviderTest {
	ServiceFactory factory = ServiceFactory.getInstance();
	ProviderService provider = factory.getProviderService();
	final long TIME_CORRECTION = 100;
	
	@Test
	public void addNoteTest() {
		NoteBook noteBook = new NoteBook();
		String noteText = "Test text";
		Assert.assertEquals(noteBook.getNote().size(), 0);
		long time = System.currentTimeMillis();
		provider.addNote(noteBook, noteText);
		Assert.assertTrue(Math.abs(noteBook.getNote(0).getTime() - time) < TIME_CORRECTION);
		Assert.assertEquals(noteBook.getNote().size(), 1);
		Assert.assertEquals(noteBook.getNote(0).getText(), noteText);
	}
	
	@Test
	public void createNoteBookTest() {
		long time = System.currentTimeMillis();
		NoteBook noteBook = provider.createNoteBook();
		Assert.assertTrue(Math.abs(noteBook.getCreationTime() - time) < TIME_CORRECTION);
		Assert.assertEquals(noteBook.getNote().size(), 0);
	}	
	
	@Test
	public void findByNoteDateTest() {
		String noteText = "Test text";
		NoteBook noteBook = new NoteBook();
		long time = System.currentTimeMillis();
		Note note = new Note(noteText, time);
		noteBook.addNote(note);
		List<Note> notes = provider.findByNoteDate(noteBook, time);
		Assert.assertEquals(notes.size(), 1);
		Assert.assertTrue(notes.get(0).equals(note));
	}
	
	@Test
	public void findByNoteTextTest() {
		String noteText = "Test text";
		NoteBook noteBook = new NoteBook();
		long time = System.currentTimeMillis();
		Note note = new Note(noteText, time);
		noteBook.addNote(note);
		List<Note> notes = provider.findByNoteText(noteBook, noteText);
		Assert.assertEquals(notes.size(), 1);
		Assert.assertTrue(notes.get(0).equals(note));
	}
}
