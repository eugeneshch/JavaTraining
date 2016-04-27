package by.epam.nb.bean;

import java.util.ArrayList;
import java.util.List;

public class NoteBook {
	private List<Note> notes;
	private long creationTime;

	public NoteBook() {
		notes = new ArrayList<Note>();
	}
	
	public NoteBook(long creationTime) {
		notes = new ArrayList<Note>();
		this.creationTime = creationTime;
	}
	
	public Note getNote(int index) {
		return notes.get(index);
	}

	public void setNote(int index, Note note) {
		this.notes.set(index, note);
	}
	
	public List<Note> getNote() {
		return notes;
	}

	public void setNote(ArrayList<Note> notes) {
		this.notes = new ArrayList<Note>(notes);
	}
	
	public void addNote(Note note) {
		this.notes.add(note);
	}
	
	public long getCreationTime() {
		return creationTime;
	}
	
	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (null == obj) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		NoteBook notebook = (NoteBook) obj;
		if (creationTime != notebook.creationTime) {
			return false;
		}	
		if (null == notes) {
			return (notes == notebook.notes);
		} else if (!notes.equals(notebook.notes)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return (int) (31 * creationTime + ((notes == null) ? 0 : notes.hashCode()));
	}

	@Override
	public String toString() {
		return getClass().getName() + "@" + "notes: " + notes.toString() + ", creationTime: " + creationTime;
	}
}
