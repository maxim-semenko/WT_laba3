package by.epam.task03.server.command;

import by.epam.task03.server.command.exception.CommandException;
import by.epam.task03.server.command.impl.AuthCommand;
import by.epam.task03.server.command.impl.CreateCommand;
import by.epam.task03.server.command.impl.DisconnectCommand;
import by.epam.task03.server.command.impl.EditCommand;
import by.epam.task03.server.command.impl.ViewCommand;

/**
 * The type Command provider.
 */
public class CommandProvider {
    private static final CommandProvider INSTANCE = new CommandProvider();

    private CommandProvider() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CommandProvider getInstance() {
        return INSTANCE;
    }

    /**
     * Gets command.
     *
     * @param request the request
     * @return the command
     * @throws CommandException the command exception
     */
    public Command getCommand(String request) throws CommandException {
        if (request == null) {
            throw new CommandException("No command");
        }

        String[] arguments = request.split(" ");

        if (arguments.length < 1) {
            throw new CommandException("No command");
        }
        switch (arguments[0]) {
            case "AUTH":
                return new AuthCommand();
            case "DISCONNECT":
                new DisconnectCommand();
            case "EDIT":
                new EditCommand();
            case "VIEW":
                new ViewCommand();
            case "CREATE":
                new CreateCommand();
            default:
                throw new CommandException("No such command");
        }
    }
}
