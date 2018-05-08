package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.BouquetOrder;

import java.util.List;

public class BouquetOrderDaoImpl implements Dao<BouquetOrder> {
    private static final Logger logger = LoggerFactory.getLogger(BouquetOrderDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(BouquetOrder bouquetOrder) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(bouquetOrder);
        logger.info("BouquetOrder successfully saved. BouquetOrder details: " + bouquetOrder);
    }

    @Override
    public void update(BouquetOrder bouquetOrder) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(bouquetOrder);
        logger.info("BouquetOrder successfully updated. BouquetOrder details: " + bouquetOrder);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        BouquetOrder bouquetOrder = (BouquetOrder) session.load(BouquetOrder.class, new Integer(id));

        if(bouquetOrder!=null){
            session.delete(bouquetOrder);
        }
        logger.info("BouquetOrder successfully removed. BouquetOrder details: " + bouquetOrder);
    }

    @Override
    public BouquetOrder getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        BouquetOrder bouquetOrder = (BouquetOrder) session.load(BouquetOrder.class, new Integer(id));
        logger.info("BouquetOrder successfully loaded. BouquetOrder details: " + bouquetOrder);

        return bouquetOrder;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BouquetOrder> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<BouquetOrder> bouquetOrderList = session.createQuery("from BouquetOrder").list();

        for(BouquetOrder bouquetOrder: bouquetOrderList){
            logger.info("BouquetOrder list: " + bouquetOrder);
        }

        return bouquetOrderList;
    }
}

