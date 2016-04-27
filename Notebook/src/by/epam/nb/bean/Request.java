package by.epam.nb.bean;

import java.util.List;

public class Request {
	private String commandName;
	private String noteBookName;
	private String noteText;
	private List<Note> listNotes;
	private Note note;
	private NoteBook noteBook;
	private long date;

	public String getNoteBookName() {
		return noteBookName;
	}

	public void setNoteBookName(String noteBookName) {
		this.noteBookName = noteBookName;
	}
	
	public String getNoteText() {
		return noteText;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}
	
	public List<Note> getListNotes() {
		return listNotes;
	}
	public void setListNotes(List<Note> listNotes) {
		this.listNotes = listNotes;
	}
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	
	public NoteBook getNoteBook() {
		return noteBook;
	}

	public void setNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	
	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
}
