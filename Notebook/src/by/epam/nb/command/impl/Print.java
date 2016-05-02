package by.epam.nb.command.impl;

import by.epam.nb.bean.Request;
import by.epam.nb.bean.Response;
import by.epam.nb.command.Command;
import by.epam.nb.view.ConsoleView;
import by.epam.nb.view.ViewFactory;

public class Print implements Command {

	@Override
	public Response execute(Request request) {
		ViewFactory factory = ViewFactory.getInstance();
		ConsoleView printer = factory.getConsoleView();
		if (request.getNoteBook() != null) {
			printer.print(request.getNoteBook());
		} else if (request.getListNotes() != null) {
			printer.print(request.getListNotes());
		} else if (request.getNote() != null) {
			printer.print(request.getNote());
		}
		Response response = new Response();
		response.setErrorMessage(null);
		return response;
	}

}
