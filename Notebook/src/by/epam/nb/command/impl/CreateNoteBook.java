package by.epam.nb.command.impl;

import by.epam.nb.bean.NoteBook;
import by.epam.nb.bean.Request;
import by.epam.nb.bean.Response;
import by.epam.nb.command.Command;
import by.epam.nb.service.ProviderService;
import by.epam.nb.service.ServiceFactory;

public class CreateNoteBook implements Command {

	@Override
	public Response execute(Request request) {
		ServiceFactory factory = ServiceFactory.getInstance();
		ProviderService provider = factory.getProviderService();
		NoteBook noteBook = provider.createNoteBook();
		Response response = new Response();
		response.setNoteBook(noteBook);
		response.setErrorMessage(null);
		return response;
	}

}
