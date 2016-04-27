package by.epam.nb.controller;

import by.epam.nb.bean.Request;
import by.epam.nb.bean.Response;
import by.epam.nb.command.Command;

public class Controller {
	private final CommandHelper helper = new CommandHelper();
	
	public Controller(){}
	
	
	public Response doAction(Request request){
		
		String commandName = request.getCommandName();
		Command command = helper.getCommand(commandName);
		Response response = command.execute(request);
		return response;
	}
		
}
