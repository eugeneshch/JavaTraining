package by.epam.nb.bean;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NoteTest {
	
	@DataProvider
	public Object[][] dp() {
		long time = System.currentTimeMillis();
		return new Object[][] {
	    new Object[] {new Note("Test text", time), new Note("Test text", time), true},
	    new Object[] {new Note("Test text", time), new Note("Test text1", time), false},
	    new Object[] {new Note("Test text", time), new Note("Test text", time + 10), false},
	    new Object[] {new Note("Test text", time), new Note("Test text2", time + 20), false},
	  };
	}	
	
	@Test(dataProvider = "dp")
	public void noteEqualsTest(Note note1, Note note2, boolean result) {
		Assert.assertEquals(note1.equals(note2), result);
	}
}
