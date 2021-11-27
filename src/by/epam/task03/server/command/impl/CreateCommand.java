package by.epam.task03.server.command.impl;

import by.epam.task03.server.command.Command;
import by.epam.task03.server.command.exception.CommandException;
import by.epam.task03.server.model.AuthType;
import by.epam.task03.server.service.ServiceFactory;

/**
 * The type Create command.
 */
public class CreateCommand implements Command {
    @Override
    public String execute(Object caller, String request) throws CommandException {
        String[] arguments = request.split(" ");
        if (arguments.length != 3) {
            throw new CommandException("CREATE invalid syntax");
        }

        if (ServiceFactory.getInstance().getAuthService().getAuthType(caller) != AuthType.MANAGER) {
            return "Should be MANAGER";
        }

        ServiceFactory.getInstance().getCaseService().addCase(arguments[1], arguments[2]);
        return "Success";
    }
}
