package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.Recipient;

import java.util.List;

public class RecipientDaoImpl implements Dao<Recipient> {
    private static final Logger logger = LoggerFactory.getLogger(RecipientDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Recipient recipient) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(recipient);
        logger.info("Recipient successfully saved. Recipient details: " + recipient);
    }

    @Override
    public void update(Recipient recipient) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(recipient);
        logger.info("Recipient successfully updated. Recipient details: " + recipient);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Recipient recipient = (Recipient) session.load(Recipient.class, new Integer(id));

        if(recipient!=null){
            session.delete(recipient);
        }
        logger.info("Recipient successfully removed. Recipient details: " + recipient);
    }

    @Override
    public Recipient getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Recipient recipient = (Recipient) session.load(Recipient.class, new Integer(id));
        logger.info("Recipient successfully loaded. Recipient details: " + recipient);

        return recipient;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Recipient> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Recipient> recipientList = session.createQuery("from Recipient").list();

        for(Recipient recipient: recipientList){
            logger.info("Recipient list: " + recipient);
        }

        return recipientList;
    }
}

