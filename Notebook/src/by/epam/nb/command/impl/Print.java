package by.epam.nb.command.impl;

import by.epam.nb.bean.Request;
import by.epam.nb.bean.Response;
import by.epam.nb.command.Command;
import by.epam.nb.service.PrinterService;
import by.epam.nb.service.ServiceFactory;

public class Print implements Command {

	@Override
	public Response execute(Request request) {
		ServiceFactory factory = ServiceFactory.getInstance();
		PrinterService printer = factory.getPrinterService();
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
