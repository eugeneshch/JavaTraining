package by.epam.nb.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import by.epam.nb.bean.Note;
import by.epam.nb.bean.NoteBook;
import by.epam.nb.dao.UserDao;
import by.epam.nb.dao.exception.DaoException;
import by.epam.nb.start.Main;

public class FileUserDao implements UserDao {
	
	private String repositoryPath;

	private void readProperties() throws DaoException {
		String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		try (FileInputStream fis = new FileInputStream(path + "../data/properties.txt")) {
			Properties p = new Properties();
			p.load(fis);
			repositoryPath = p.getProperty("RepositoryPath");
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}
	
	@Override
	public NoteBook loadNoteBook(String name) throws DaoException {
		readProperties();
		File file = new File(repositoryPath + name);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String str = br.readLine();
			NoteBook noteBook = new NoteBook(Long.parseLong(str));
			while ((str = br.readLine()) != null) {
				long time = Long.parseLong(str.substring(0, str.indexOf(" ")));
				noteBook.addNote(new Note(str.substring(str.indexOf(" ") + 1), time));
				}
			return noteBook;
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void saveNoteBook(String name, NoteBook noteBook) throws DaoException {
		readProperties();
		File file = new File(repositoryPath + name);
		try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
			pw.println(noteBook.getCreationTime());
			for (Note note : noteBook.getNote()) {
				pw.println(note.getTime() + " " + note.getText());
			}
		} catch (IOException e) {
			throw new DaoException(e);
		}		
	}
}
