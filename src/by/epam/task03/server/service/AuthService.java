package by.epam.task03.server.service;

import by.epam.task03.server.model.AuthType;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Auth service.
 */
public class AuthService {
    private static final AuthService INSTANCE = new AuthService();

    private final Map<Object, AuthType> users;

    private AuthService() {
        users = new HashMap<>();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static AuthService getInstance() {
        return INSTANCE;
    }

    /**
     * Gets auth type.
     *
     * @param user the user
     * @return the auth type
     */
    public AuthType getAuthType(Object user) {
        if (!users.containsKey(user)) {
            users.put(user, AuthType.UNAUTH);
        }

        return users.get(user);
    }

    /**
     * Sets auth type.
     *
     * @param user the user
     * @param type the type
     */
    public void setAuthType(Object user, AuthType type) {
        users.put(user, type);
    }
}