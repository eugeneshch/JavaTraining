package by.epam.nb.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.epam.nb.bean.Note;
import by.epam.nb.bean.NoteBook;
import by.epam.nb.dao.DAOFactory;
import by.epam.nb.dao.UserDao;
import by.epam.nb.service.ProviderService;

public class NoteBookProvider implements ProviderService {

	@Override
	public void addNote(NoteBook noteBook, String noteText) {		
		noteBook.addNote(new Note(noteText, System.currentTimeMillis()));		
	}

	@Override
	public NoteBook createNoteBook() {
		return new NoteBook(System.currentTimeMillis());
	}

	@Override
	public List<Note> findByNoteDate(NoteBook noteBook, long date) {
		List<Note> notes = new ArrayList<Note>();
		for (Note note : noteBook.getNote()) {
			if (note.getTime() == date) {
				notes.add(note);
			}
		}
		return notes;
	}

	@Override
	public List<Note> findByNoteText(NoteBook noteBook, String noteText) {
		List<Note> notes = new ArrayList<Note>();
		for (Note note : noteBook.getNote()) {
			if (note.getText() == noteText) {
				notes.add(note);
			}
		}
		return notes;
	}

	@Override
	public NoteBook loadNotebook(String name) {
		DAOFactory factory = DAOFactory.getInstance();
		UserDao userDao = factory.getUserDao();
		return userDao.loadNoteBook(name);
	}

	@Override
	public void saveNotebook(String name, NoteBook noteBook) {
		DAOFactory factory = DAOFactory.getInstance();
		UserDao userDao = factory.getUserDao();
		userDao.saveNoteBook(name, noteBook);
	}

}
