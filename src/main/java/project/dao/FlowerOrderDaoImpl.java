package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.FlowerOrder;

import java.util.List;

public class FlowerOrderDaoImpl implements Dao<FlowerOrder> {
    private static final Logger logger = LoggerFactory.getLogger(FlowerOrderDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(FlowerOrder flowerOrder) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(flowerOrder);
        logger.info("FlowerOrder successfully saved. FlowerOrder details: " + flowerOrder);
    }

    @Override
    public void update(FlowerOrder flowerOrder) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(flowerOrder);
        logger.info("FlowerOrder successfully updated. FlowerOrder details: " + flowerOrder);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        FlowerOrder flowerOrder = (FlowerOrder) session.load(FlowerOrder.class, new Integer(id));

        if(flowerOrder!=null){
            session.delete(flowerOrder);
        }
        logger.info("FlowerOrder successfully removed. FlowerOrder details: " + flowerOrder);
    }

    @Override
    public FlowerOrder getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        FlowerOrder flowerOrder = (FlowerOrder) session.load(FlowerOrder.class, new Integer(id));
        logger.info("FlowerOrder successfully loaded. FlowerOrder details: " + flowerOrder);

        return flowerOrder;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<FlowerOrder> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<FlowerOrder> flowerOrderList = session.createQuery("from FlowerOrder").list();

        for(FlowerOrder flowerOrder: flowerOrderList){
            logger.info("FlowerOrder list: " + flowerOrder);
        }

        return flowerOrderList;
    }

    @Override
    public List<FlowerOrder> listWhere(String where) {
        return null;
    }
}

