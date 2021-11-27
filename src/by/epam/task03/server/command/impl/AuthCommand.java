package by.epam.task03.server.command.impl;

import by.epam.task03.server.command.Command;
import by.epam.task03.server.command.exception.CommandException;
import by.epam.task03.server.model.AuthType;
import by.epam.task03.server.service.ServiceFactory;

/**
 * The type Auth command.
 */
public class AuthCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        String[] arguments = request.split(" ");
        if (arguments.length != 2) {
            throw new CommandException("AUTH command should contain 1 argument");
        }
        AuthType authType;
        try {
            authType = AuthType.valueOf(arguments[1]);
        } catch (IllegalArgumentException e) {
            throw new CommandException("No such auth type");
        }

        ServiceFactory.getInstance().getAuthService().setAuthType(caller, authType);
        return "Success.";
    }
}
