package by.epam.nb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.nb.bean.Request;
import by.epam.nb.bean.Response;
import by.epam.nb.command.Command;
import by.epam.nb.command.exceptions.CommandException;

public class Controller {
	private final CommandHelper helper = new CommandHelper();
	//private final Logger rootLogger = LogManager.getRootLogger();
	private final Logger log = LogManager.getLogger("MyLogger");
	
	public Controller(){}
	
	public Response doAction(Request request){
		String commandName = request.getCommandName();
		Command command = helper.getCommand(commandName);
		Response response = null;
		try {
			response = command.execute(request);
		} catch (CommandException e) {
			response = new Response();
			response.setErrorMessage(e.getMessage());
		}
		//rootLogger.info(request.getCommandName() + " Error message: " + response.getErrorMessage());
		log.debug(request.getCommandName() + " Error message: " + response.getErrorMessage());
		return response;
	}	
}
