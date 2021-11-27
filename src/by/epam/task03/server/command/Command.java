package by.epam.task03.server.command;

import by.epam.task03.server.command.exception.CommandException;

/**
 * The interface Command.
 */
public interface Command {
    /**
     * Execute string.
     *
     * @param caller  the caller
     * @param request the request
     * @return the string
     * @throws CommandException the command exception
     */
    String execute(Object caller, String request) throws CommandException;
}
