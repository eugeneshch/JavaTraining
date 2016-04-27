package by.epam.nb.dao;

import by.epam.nb.bean.NoteBook;

public interface UserDao {
	NoteBook loadNoteBook(String name);
	void saveNoteBook(String name, NoteBook noteBook);
}
