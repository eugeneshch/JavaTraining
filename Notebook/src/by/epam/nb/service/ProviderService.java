package by.epam.nb.service;

import java.util.List;

import by.epam.nb.bean.Note;
import by.epam.nb.bean.NoteBook;

public interface ProviderService {
	void addNote(NoteBook noteBook, String noteText);
	NoteBook createNoteBook();
	List<Note> findByNoteDate(NoteBook noteBook, long date);
	List<Note> findByNoteText(NoteBook noteBook, String noteText);
	NoteBook loadNotebook(String name);
	void saveNotebook(String name, NoteBook noteBook);
}
