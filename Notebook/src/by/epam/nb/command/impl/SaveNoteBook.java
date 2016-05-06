package by.epam.nb.command.impl;

import by.epam.nb.bean.Request;
import by.epam.nb.bean.Response;
import by.epam.nb.command.Command;
import by.epam.nb.command.exception.CommandException;
import by.epam.nb.service.ProviderService;
import by.epam.nb.service.ServiceFactory;
import by.epam.nb.service.exception.ServiceException;

public class SaveNoteBook implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		ServiceFactory factory = ServiceFactory.getInstance();
		ProviderService provider = factory.getProviderService();
		try {
			provider.saveNotebook(request.getNoteBookName(), request.getNoteBook());
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		Response response = new Response();
		response.setErrorMessage(null);
		return response;
	}

}
