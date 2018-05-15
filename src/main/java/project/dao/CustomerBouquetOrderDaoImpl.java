package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.CustomerBouquetOrder;

import java.util.List;

public class CustomerBouquetOrderDaoImpl implements Dao<CustomerBouquetOrder> {
    private static final Logger logger = LoggerFactory.getLogger(CustomerBouquetOrderDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(CustomerBouquetOrder customerBouquetOrder) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(customerBouquetOrder);
        logger.info("CustomerBouquetOrder successfully saved. CustomerBouquetOrder details: " + customerBouquetOrder);
    }

    @Override
    public void update(CustomerBouquetOrder customerBouquetOrder) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(customerBouquetOrder);
        logger.info("CustomerBouquetOrder successfully updated. CustomerBouquetOrder details: " + customerBouquetOrder);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CustomerBouquetOrder customerBouquetOrder = (CustomerBouquetOrder) session.load(CustomerBouquetOrder.class, new Integer(id));

        if(customerBouquetOrder!=null){
            session.delete(customerBouquetOrder);
        }
        logger.info("CustomerBouquetOrder successfully removed. CustomerBouquetOrder details: " + customerBouquetOrder);
    }

    @Override
    public CustomerBouquetOrder getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        CustomerBouquetOrder customerBouquetOrder = (CustomerBouquetOrder) session.load(CustomerBouquetOrder.class, new Integer(id));
        logger.info("CustomerBouquetOrder successfully loaded. CustomerBouquetOrder details: " + customerBouquetOrder);

        return customerBouquetOrder;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CustomerBouquetOrder> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<CustomerBouquetOrder> customerBouquetOrderList = session.createQuery("from CustomerBouquetOrder").list();

        for(CustomerBouquetOrder customerBouquetOrder: customerBouquetOrderList){
            logger.info("CustomerBouquetOrder list: " + customerBouquetOrder);
        }

        return customerBouquetOrderList;
    }

    @Override
    public List<CustomerBouquetOrder> listWhere(String where) {
        return null;
    }
}

