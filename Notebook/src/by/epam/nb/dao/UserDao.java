package by.epam.nb.dao;

import by.epam.nb.bean.NoteBook;
import by.epam.nb.dao.exception.DaoException;

public interface UserDao {
	NoteBook loadNoteBook(String name) throws DaoException ;
	void saveNoteBook(String name, NoteBook noteBook) throws DaoException ;
}
