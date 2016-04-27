package by.epam.nb.command.impl;

import java.util.List;

import by.epam.nb.bean.Note;
import by.epam.nb.bean.Request;
import by.epam.nb.bean.Response;
import by.epam.nb.command.Command;
import by.epam.nb.service.ProviderService;
import by.epam.nb.service.ServiceFactory;

public class FindByNoteText implements Command {

	@Override
	public Response execute(Request request) {
		ServiceFactory factory = ServiceFactory.getInstance();
		ProviderService provider = factory.getProviderService();
		List<Note> notes = provider.findByNoteText(request.getNoteBook(), request.getNoteText());
		Response response = new Response();
		response.setListNotes(notes);
		response.setErrorMessage(null);
		return response;
	}

}
