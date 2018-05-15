package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.DecorationCustomerBouquet;

import java.util.List;

public class DecorationCustomerBouquetDaoImpl implements Dao<DecorationCustomerBouquet> {
    private static final Logger logger = LoggerFactory.getLogger(DecorationCustomerBouquetDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(DecorationCustomerBouquet flowerCustomerBouquet) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(flowerCustomerBouquet);
        logger.info("DecorationCustomerBouquet successfully saved. DecorationCustomerBouquet details: " + flowerCustomerBouquet);
    }

    @Override
    public void update(DecorationCustomerBouquet flowerCustomerBouquet) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(flowerCustomerBouquet);
        logger.info("DecorationCustomerBouquet successfully updated. DecorationCustomerBouquet details: " + flowerCustomerBouquet);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        DecorationCustomerBouquet flowerCustomerBouquet = (DecorationCustomerBouquet) session.load(DecorationCustomerBouquet.class, new Integer(id));

        if(flowerCustomerBouquet!=null){
            session.delete(flowerCustomerBouquet);
        }
        logger.info("DecorationCustomerBouquet successfully removed. DecorationCustomerBouquet details: " + flowerCustomerBouquet);
    }

    @Override
    public DecorationCustomerBouquet getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        DecorationCustomerBouquet flowerCustomerBouquet = (DecorationCustomerBouquet) session.load(DecorationCustomerBouquet.class, new Integer(id));
        logger.info("DecorationCustomerBouquet successfully loaded. DecorationCustomerBouquet details: " + flowerCustomerBouquet);

        return flowerCustomerBouquet;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DecorationCustomerBouquet> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<DecorationCustomerBouquet> flowerCustomerBouquetList = session.createQuery("from DecorationCustomerBouquet").list();

        for(DecorationCustomerBouquet flowerCustomerBouquet: flowerCustomerBouquetList){
            logger.info("DecorationCustomerBouquet list: " + flowerCustomerBouquet);
        }

        return flowerCustomerBouquetList;
    }

    @Override
    public List<DecorationCustomerBouquet> listWhere(String where) {
        return null;
    }
}

