package by.epam.nb.command.impl;

import by.epam.nb.bean.Request;
import by.epam.nb.bean.Response;
import by.epam.nb.command.Command;
import by.epam.nb.service.ProviderService;
import by.epam.nb.service.ServiceFactory;

public class AddNote implements Command {
	
	@Override
	public Response execute(Request request) {		
		ServiceFactory factory = ServiceFactory.getInstance();
		ProviderService provider = factory.getProviderService();
		provider.addNote(request.getNoteBook(), request.getNoteText());
		Response response = new Response();
		response.setErrorMessage(null);
		return response;
	}

}
