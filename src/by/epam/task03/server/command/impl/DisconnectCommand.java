package by.epam.task03.server.command.impl;

import by.epam.task03.server.command.Command;
import by.epam.task03.server.model.AuthType;
import by.epam.task03.server.service.ServiceFactory;

/**
 * The type Disconnect command.
 */
public class DisconnectCommand implements Command {
    @Override
    public String execute(Object caller, String request) {
        ServiceFactory.getInstance().getAuthService().setAuthType(caller, AuthType.UNAUTH);
        return "Disconnect!";
    }
}
