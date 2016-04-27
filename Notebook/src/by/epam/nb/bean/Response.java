package by.epam.nb.bean;

import java.util.List;

public class Response {
	private List<Note> listNotes;
	private Note note;
	private NoteBook noteBook;
	private String errorMessage;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
