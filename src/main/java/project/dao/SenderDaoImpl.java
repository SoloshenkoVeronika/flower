package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.Sender;

import java.util.List;

public class SenderDaoImpl implements Dao<Sender> {
    private static final Logger logger = LoggerFactory.getLogger(SenderDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Sender sender) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(sender);
        logger.info("Sender successfully saved. Sender details: " + sender);
    }

    @Override
    public void update(Sender sender) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(sender);
        logger.info("Sender successfully updated. Sender details: " + sender);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Sender sender = (Sender) session.load(Sender.class, new Integer(id));

        if(sender!=null){
            session.delete(sender);
        }
        logger.info("Sender successfully removed. Sender details: " + sender);
    }

    @Override
    public Sender getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Sender sender = (Sender) session.load(Sender.class, new Integer(id));
        logger.info("Sender successfully loaded. Sender details: " + sender);

        return sender;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Sender> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Sender> senderList = session.createQuery("from Sender").list();

        for(Sender sender: senderList){
            logger.info("Sender list: " + sender);
        }

        return senderList;
    }
}

