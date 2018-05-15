package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.FlowerCustomerBouquet;

import java.util.List;

public class FlowerCustomerBouquetDaoImpl implements Dao<FlowerCustomerBouquet> {
    private static final Logger logger = LoggerFactory.getLogger(FlowerCustomerBouquetDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(FlowerCustomerBouquet flowerCustomerBouquet) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(flowerCustomerBouquet);
        logger.info("FlowerCustomerBouquet successfully saved. FlowerCustomerBouquet details: " + flowerCustomerBouquet);
    }

    @Override
    public void update(FlowerCustomerBouquet flowerCustomerBouquet) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(flowerCustomerBouquet);
        logger.info("FlowerCustomerBouquet successfully updated. FlowerCustomerBouquet details: " + flowerCustomerBouquet);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        FlowerCustomerBouquet flowerCustomerBouquet = (FlowerCustomerBouquet) session.load(FlowerCustomerBouquet.class, new Integer(id));

        if(flowerCustomerBouquet!=null){
            session.delete(flowerCustomerBouquet);
        }
        logger.info("FlowerCustomerBouquet successfully removed. FlowerCustomerBouquet details: " + flowerCustomerBouquet);
    }

    @Override
    public FlowerCustomerBouquet getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        FlowerCustomerBouquet flowerCustomerBouquet = (FlowerCustomerBouquet) session.load(FlowerCustomerBouquet.class, new Integer(id));
        logger.info("FlowerCustomerBouquet successfully loaded. FlowerCustomerBouquet details: " + flowerCustomerBouquet);

        return flowerCustomerBouquet;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<FlowerCustomerBouquet> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<FlowerCustomerBouquet> flowerCustomerBouquetList = session.createQuery("from FlowerCustomerBouquet").list();

        for(FlowerCustomerBouquet flowerCustomerBouquet: flowerCustomerBouquetList){
            logger.info("FlowerCustomerBouquet list: " + flowerCustomerBouquet);
        }

        return flowerCustomerBouquetList;
    }

    @Override
    public List<FlowerCustomerBouquet> listWhere(String where) {
        return null;
    }
}

