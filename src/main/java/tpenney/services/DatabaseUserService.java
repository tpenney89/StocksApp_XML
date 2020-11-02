package tpenney.services;

import tpenney.model.User;
import tpenney.model.PersonDAO;
import tpenney.model.PersonStocksDAO;
import tpenney.model.StockSymbolDAO;
import tpenney.util.DatabaseUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

class DatabaseUserService implements UserService {

    @Override
    public void addPerson(User user) throws UserServiceException, DuplicateUserNameException {
        Transaction transaction = null;
        Session session = null;
        try {
            session = DatabaseUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            PersonDAO personDAO = new PersonDAO();
            personDAO.setUserName(user.getUserName());
            session.saveOrUpdate(personDAO);
            transaction.commit();
        } catch (ConstraintViolationException e) {
            throw new DuplicateUserNameException(user.getUserName() + " already exists");
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new UserServiceException(e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                // if we get there there's an error to deal with
                transaction.rollback();  //  close transaction
            }
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void associateStockWithPerson(String symbol, User user)
            throws UnknownStockSymbolException, UnknownUserException, UserServiceException {

        PersonDAO personDAO = DatabaseUtils.findUniqueResultBy("username", user.getUserName(), PersonDAO.class, true);
        if (personDAO == null) {
            throw new UnknownUserException("No Person record found with username of " + user.getUserName());
        }
        StockSymbolDAO stockSymbolDAO = DatabaseUtils.findUniqueResultBy("symbol", symbol, StockSymbolDAO.class, true);
        if (stockSymbolDAO == null) {
            throw new UnknownStockSymbolException("No Stock Symbol record for: " + symbol);
        }
        PersonStocksDAO personStocksDAO = new PersonStocksDAO();
        personStocksDAO.setPersonDAO(personDAO);
        //  personStocksDAO.setPersonByPersonId(stockSymbolDAO);
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(personStocksDAO);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }
}
