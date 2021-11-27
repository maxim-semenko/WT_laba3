package by.epam.task03.server.dao;

/**
 * The type Dao factory.
 */
public class DaoFactory {
    private static final DaoFactory INSTANCE = new DaoFactory();

    private DaoFactory() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static DaoFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Gets case dao.
     *
     * @return the case dao
     */
    public CaseDao getCaseDao() {
        return CaseDao.getInstance();
    }
}