package by.epam.nb.view;

import by.epam.nb.view.impl.NoteBookConsoleView;

public class ViewFactory {
	private static ViewFactory factory = new ViewFactory();

	private final ConsoleView consoleView = new NoteBookConsoleView();
	
	private ViewFactory(){}
	
	public static ViewFactory getInstance(){
		return factory;
	}
	
	public ConsoleView getConsoleView(){
		return consoleView;
	}
}
