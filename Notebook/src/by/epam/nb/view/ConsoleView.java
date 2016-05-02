package by.epam.nb.view;

import java.util.List;

import by.epam.nb.bean.Note;
import by.epam.nb.bean.NoteBook;

public interface ConsoleView {
	void print(Note note);
	void print(Note... notes);
	void print(List<Note> listNotes);
	void print(NoteBook noteBook);
}
