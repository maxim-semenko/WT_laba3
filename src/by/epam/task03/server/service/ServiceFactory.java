package by.epam.task03.server.service;

/**
 * The type Service factory.
 */
public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private ServiceFactory() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Gets auth service.
     *
     * @return the auth service
     */
    public AuthService getAuthService() {
        return AuthService.getInstance();
    }

    /**
     * Gets case service.
     *
     * @return the case service
     */
    public CaseService getCaseService() {
        return CaseService.getInstance();
    }
}