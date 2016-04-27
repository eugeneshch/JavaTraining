package by.epam.nb.service;

import java.util.List;

import by.epam.nb.bean.Note;
import by.epam.nb.bean.NoteBook;

public interface PrinterService {
	void print(Note note);
	void print(Note... notes);
	void print(List<Note> listNotes);
	void print(NoteBook noteBook);
}
