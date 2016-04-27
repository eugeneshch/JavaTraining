package by.epam.nb.command;

import by.epam.nb.bean.Request;
import by.epam.nb.bean.Response;

public interface Command {
	Response execute(Request request);
}
