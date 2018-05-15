package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.CustomerBouquet;

import java.util.List;

public class CustomerBouquetDaoImpl implements Dao<CustomerBouquet> {
    private static final Logger logger = LoggerFactory.getLogger(CustomerBouquetDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(CustomerBouquet customerBouquet) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(customerBouquet);
        logger.info("CustomerBouquet successfully saved. CustomerBouquet details: " + customerBouquet);
    }

    @Override
    public void update(CustomerBouquet customerBouquet) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(customerBouquet);
        logger.info("CustomerBouquet successfully updated. CustomerBouquet details: " + customerBouquet);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CustomerBouquet customerBouquet = (CustomerBouquet) session.load(CustomerBouquet.class, new Integer(id));

        if(customerBouquet!=null){
            session.delete(customerBouquet);
        }
        logger.info("CustomerBouquet successfully removed. CustomerBouquet details: " + customerBouquet);
    }

    @Override
    public CustomerBouquet getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        CustomerBouquet customerBouquet = (CustomerBouquet) session.load(CustomerBouquet.class, new Integer(id));
        logger.info("CustomerBouquet successfully loaded. CustomerBouquet details: " + customerBouquet);

        return customerBouquet;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CustomerBouquet> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<CustomerBouquet> customerBouquetList = session.createQuery("from CustomerBouquet").list();

        for(CustomerBouquet customerBouquet: customerBouquetList){
            logger.info("CustomerBouquet list: " + customerBouquet);
        }

        return customerBouquetList;
    }

    @Override
    public List<CustomerBouquet> listWhere(String where) {
        return null;
    }
}

