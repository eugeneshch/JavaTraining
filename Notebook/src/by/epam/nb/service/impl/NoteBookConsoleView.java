package by.epam.nb.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import by.epam.nb.bean.Note;
import by.epam.nb.bean.NoteBook;
import by.epam.nb.service.PrinterService;

public class NoteBookConsoleView implements PrinterService {

	@Override
	public void print(Note note) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");    
		Date resultDate = new Date(note.getTime());
		System.out.println(sdf.format(resultDate));
		System.out.println(note.getText());
	}

	@Override
	public void print(Note... notes) {
		for (Note note : notes) {
			print(note);
		}
	}

	@Override
	public void print(NoteBook noteBook) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");    
		Date resultDate = new Date(noteBook.getCreationTime());
		System.out.println("NoteBook creation time - " + sdf.format(resultDate));
		print(noteBook.getNote());
	}

	@Override
	public void print(List<Note> listNotes) {
		for (Note note : listNotes) {
			print(note);
		}
	}

}
