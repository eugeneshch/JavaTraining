package by.epam.nb.controller;

import java.util.HashMap;
import java.util.Map;

import by.epam.nb.command.Command;
import by.epam.nb.command.impl.AddNote;
import by.epam.nb.command.impl.CreateNoteBook;
import by.epam.nb.command.impl.FindByNoteDate;
import by.epam.nb.command.impl.FindByNoteText;
import by.epam.nb.command.impl.LoadNoteBook;
import by.epam.nb.command.impl.SaveNoteBook;

public class CommandHelper {
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandHelper(){
		commands.put(CommandName.CREATE_NOTEBOOK_COMMAND, new CreateNoteBook());
		commands.put(CommandName.ADD_NOTE_COMMAND, new AddNote());
		commands.put(CommandName.FIND_BY_NOTE_TEXT_COMMAND, new FindByNoteText());
		commands.put(CommandName.FIND_BY_NOTE_DATE_COMMAND, new FindByNoteDate());
		commands.put(CommandName.SAVE_NOTEBOOK_COMMAND, new SaveNoteBook());
		commands.put(CommandName.LOAD_NOTEBOOK_COMMAND, new LoadNoteBook());
	}
	
	public Command getCommand(String commandName){//"REGISTER_USER"
		CommandName command = CommandName.valueOf(commandName);
		Command executeCommand = commands.get(command);
		return executeCommand;
	}
}
