package tpenney.services;

import tpenney.util.DatabaseInitializationException;
import tpenney.util.DatabaseUtils;
import org.junit.After;
import org.junit.Before;

/**
 * Base class for service tests that use the DBMS.
 *
 * Note package scope since only a few specific test classes should use the DBMS for
 * testing. Tests that do not directly require the DBMS should use mocks.
 */
public class DatabaseServiceTest {

    @Before
    public void setUp() throws DatabaseInitializationException {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    @After
    public void tearDown() throws DatabaseInitializationException {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }
}
