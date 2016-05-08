package by.epam.nb.command.exception;

public class CommandException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public CommandException(Exception e) {
		super(e);
	}
}
