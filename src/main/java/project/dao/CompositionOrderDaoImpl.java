package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.CompositionOrder;

import java.util.List;

public class CompositionOrderDaoImpl implements Dao<CompositionOrder> {
    private static final Logger logger = LoggerFactory.getLogger(CompositionOrderDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(CompositionOrder compositionOrder) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(compositionOrder);
        logger.info("CompositionOrder successfully saved. CompositionOrder details: " + compositionOrder);
    }

    @Override
    public void update(CompositionOrder compositionOrder) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(compositionOrder);
        logger.info("CompositionOrder successfully updated. CompositionOrder details: " + compositionOrder);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CompositionOrder compositionOrder = (CompositionOrder) session.load(CompositionOrder.class, new Integer(id));

        if(compositionOrder!=null){
            session.delete(compositionOrder);
        }
        logger.info("CompositionOrder successfully removed. CompositionOrder details: " + compositionOrder);
    }

    @Override
    public CompositionOrder getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        CompositionOrder compositionOrder = (CompositionOrder) session.load(CompositionOrder.class, new Integer(id));
        logger.info("CompositionOrder successfully loaded. CompositionOrder details: " + compositionOrder);

        return compositionOrder;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CompositionOrder> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<CompositionOrder> compositionOrderList = session.createQuery("from CompositionOrder").list();

        for(CompositionOrder compositionOrder: compositionOrderList){
            logger.info("CompositionOrder list: " + compositionOrder);
        }

        return compositionOrderList;
    }
}

