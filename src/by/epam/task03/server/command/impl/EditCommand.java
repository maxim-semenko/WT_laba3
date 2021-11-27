package by.epam.task03.server.command.impl;

import by.epam.task03.server.command.Command;
import by.epam.task03.server.command.exception.CommandException;
import by.epam.task03.server.model.AuthType;
import by.epam.task03.server.service.ServiceFactory;

/**
 * The type Edit command.
 */
public class EditCommand implements Command {

    @Override
    public String execute(Object caller, String request) throws CommandException {
        String[] arguments = request.split(" ");
        if (arguments.length != 4) {
            throw new CommandException("Invalid syntax EDIT");
        }

        if (ServiceFactory.getInstance().getAuthService().getAuthType(caller) != AuthType.MANAGER) {
            return "Should be MANAGER";
        }

        int id;
        try {
            id = Integer.parseInt(arguments[1]);
        } catch (NumberFormatException ignored) {
            return "Invalid id";
        }

        if (!ServiceFactory.getInstance().getCaseService().containsCase(id)) {
            return "No such case";
        }

        ServiceFactory.getInstance().getCaseService().editCase(id, arguments[2], arguments[3]);

        return "Success";
    }
}
