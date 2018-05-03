package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao<User> {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private User getUser(User user){
        Session session = this.sessionFactory.getCurrentSession();
        ArrayList<User> users = (ArrayList) session.createQuery("from User where login = '"+user.getLogin()+"' and password = '"+user.getPassword()+"'").list();
        for(int i = 0; i <users.size(); i++){
            user = users.get(i);
        }
        return user;
    }

    @Override
    public User add(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        if (user.getLogin().equals("admin")){
            user.setStatus(1);
        } else {
            user.setStatus(0);
        }
        session.persist(user);
        logger.info("User successfully saved. User details: " + user);
        return getUser(user);
    }

    @Override
    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully updated. User details: " + user);
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
    @SuppressWarnings("unchecked")
    public List<User> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();

        for(User user: userList){
            logger.info("User list: " + user);
        }

        return userList;
    }

    @Override
    public User isAuthorized(User user) {
//        System.out.println("rrrrr");
        user = getUser(user);
        if (user.getId() != null) {
            logger.info("User successfully loaded. User details: " + user);
        }

        //if(session.createQuery("from User where login = '"+user.getLogin()+"' and password = '"+user.getPassword()+"'").iterate().hasNext()){
//            System.out.println("e122221111e");

        else{
            System.out.println("neeet");
            logger.info("User successfully loaded. User details: " + user);
        }
        return user;
    }
}

