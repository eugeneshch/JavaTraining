package by.epam.nb.command;

import by.epam.nb.bean.Request;
import by.epam.nb.bean.Response;
import by.epam.nb.command.exception.CommandException;

public interface Command {
	Response execute(Request request) throws CommandException;
}
