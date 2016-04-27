package by.epam.nb.bean;

public class Note {
	private String text;
	private long time;

	public Note(){
	}
	
	public Note(String text, long time){
		this.text = text;
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
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
		Note note = (Note) obj;
		if (time != note.time) {
			return false;
		}	
		if (null == text) {
			return (text == note.text);
		} else if (!text.equals(note.text)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return (int) (31 * time + ((text == null) ? 0 : text.hashCode()));
	}

	@Override
	public String toString() {
		return getClass().getName() + "@" + "text: " + text + ", time: " + time;
	}
	
	
}
