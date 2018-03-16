package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("Book successfully saved. Book details: " + user);
    }

    @Override
    public void updateUser(User book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book successfully update. Book details: " + book);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User book = (User) session.load(User.class, new Integer(id));

        if(book!=null){
            session.delete(book);
        }
        logger.info("Book successfully removed. Book details: " + book);
    }

    @Override
    public User getUserById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        User book = (User) session.load(User.class, new Integer(id));
        logger.info("Book successfully loaded. Book details: " + book);

        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> bookList = session.createQuery("from User").list();

        for(User book: bookList){
            logger.info("Book list: " + book);
        }

        return bookList;
    }
}

