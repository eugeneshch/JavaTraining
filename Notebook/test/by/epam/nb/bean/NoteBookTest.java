package by.epam.nb.bean;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NoteBookTest {
	@DataProvider
	public Object[][] dp() {
		long time = System.currentTimeMillis();
		NoteBook noteBookWithNote1 = new NoteBook(time);
		Note note = new Note("Test note", time);
		noteBookWithNote1.addNote(note);
		NoteBook noteBookWithNote2 = new NoteBook(time);
		noteBookWithNote2.addNote(note);
		return new Object[][] {
	    new Object[] {new NoteBook(time), new NoteBook(time), true},
	    new Object[] {new NoteBook(time), new NoteBook(time + 10), false},
	    new Object[] {new NoteBook(time), noteBookWithNote1, false},
	    new Object[] {noteBookWithNote1, noteBookWithNote2, true},
	  };
	}	
	
	@Test(dataProvider = "dp")
	public void noteBookEqualsTest(NoteBook noteBook1, NoteBook noteBook2, boolean result) {
		Assert.assertEquals(noteBook1.equals(noteBook2), result);
	}
}
