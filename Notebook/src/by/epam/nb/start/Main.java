package by.epam.nb.start;

import by.epam.nb.bean.NoteBook;
import by.epam.nb.bean.Request;
import by.epam.nb.bean.Response;
import by.epam.nb.controller.Controller;
import by.epam.nb.view.ConsoleView;
import by.epam.nb.view.ViewFactory;

public class Main {

	public static void main(String[] args) {
			
		Controller controller = new Controller();
		Request request;
		
		request = new Request();
		request.setCommandName("CREATE_NOTEBOOK_COMMAND");
		Response response = controller.doAction(request);
		NoteBook noteBook = response.getNoteBook(); 
		
	/*	request = new Request();
		request.setCommandName("LOAD_NOTEBOOK_COMMAND");
		request.setNoteBookName("FirstNoteBook.txt");
		Response response = controller.doAction(request);
		NoteBook noteBook = response.getNoteBook(); */
		
		request = new Request();
		request.setCommandName("ADD_NOTE_COMMAND");
		request.setNoteBook(noteBook);
		request.setNoteText("First note");
		response = controller.doAction(request);
		
		request = new Request();
		request.setCommandName("ADD_NOTE_COMMAND");
		request.setNoteBook(noteBook);
		request.setNoteText("Second note");
		response = controller.doAction(request); 
		
		ViewFactory factory = ViewFactory.getInstance();
		ConsoleView printer = factory.getConsoleView();
		printer.print(noteBook);
		
		request = new Request();
		request.setCommandName("SAVE_NOTEBOOK_COMMAND");
		request.setNoteBook(noteBook);
		request.setNoteBookName("FirstNoteBook.txt");
		response = controller.doAction(request); 
	}

}
