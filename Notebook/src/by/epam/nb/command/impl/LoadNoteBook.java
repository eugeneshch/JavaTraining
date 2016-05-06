package by.epam.nb.command.impl;

import by.epam.nb.bean.NoteBook;
import by.epam.nb.bean.Request;
import by.epam.nb.bean.Response;
import by.epam.nb.command.Command;
import by.epam.nb.command.exception.CommandException;
import by.epam.nb.service.ProviderService;
import by.epam.nb.service.ServiceFactory;
import by.epam.nb.service.exception.ServiceException;

public class LoadNoteBook implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		ServiceFactory factory = ServiceFactory.getInstance();
		ProviderService provider = factory.getProviderService();
		NoteBook noteBook;
		try {
			noteBook = provider.loadNotebook(request.getNoteBookName());
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		Response response = new Response();
		response.setNoteBook(noteBook);
		response.setErrorMessage(null);
		return response;
	}

}
