package tpenney.services;

import tpenney.model.User;
import tpenney.util.DatabaseInitializationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 */
public class DatabaseUserServiceTest extends DatabaseServiceTest{


    private UserService databaseUserService;

    @Before
    public void setUp() throws DatabaseInitializationException {
        super.setUp();
        databaseUserService = ServiceFactory.getUserService();
    }
    @Ignore
    @Test
    public void testAddPerson() throws Exception{
        String sam = "Vic";
        User user = new User(sam);
        databaseUserService.addPerson(user);
    }

    @Ignore
    @Test(expected = DuplicateUserNameException.class)
    public void testAddPersonDuplicateUser() throws Exception{
        String sam = "Sam";
        User user = new User(sam);
        databaseUserService.addPerson(user);

    }

}
