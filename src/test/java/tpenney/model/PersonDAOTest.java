package tpenney.model;

import org.junit.Ignore;
import tpenney.util.DatabaseUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Verify the PersonDAO class
 */
public class PersonDAOTest extends AbstractBaseDAOTest {

    @Ignore
    @Test
    public void testRead() {
        PersonDAO personDAO = DatabaseUtils.findUniqueResultBy("id", 1, PersonDAO.class, true);
        assertTrue("first PersonDAO found", personDAO.getId() == 1);
    }

    @Ignore
    @Test
    public void testWrite() throws Exception {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        PersonDAO personDAO = new PersonDAO();
        personDAO.setUserName("spencer");
        session.saveOrUpdate(personDAO);
        transaction.commit();
    }


}
