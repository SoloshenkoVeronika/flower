package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.User;

import java.util.List;

public class UserDaoImpl implements Dao<User> {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User successfully saved. User details: " + user);
    }

    @Override
    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully update. User details: " + user);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if(user!=null){
            session.delete(user);
        }
        logger.info("User successfully removed. User details: " + user);
    }

    @Override
    public User getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User successfully loaded. User details: " + user);

        return user;
    }

    @Override
    public boolean getEn(User user) {
//        System.out.println("rrrrr");
        Session session =this.sessionFactory.getCurrentSession();
        if(session.createQuery("from User where login = '"+user.getLogin()+"' and password = '"+user.getPassword()+"'").iterate().hasNext()){
//            System.out.println("e122221111e");
            logger.info("User successfully loaded. User details: " + user);
            return true;
        }
        else{
            System.out.println("neeet");
            logger.info("User successfully loaded. User details: " + user);
            return false;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();

        for(User user: userList){
            logger.info("User list: " + user);
        }

        return userList;
    }
}

