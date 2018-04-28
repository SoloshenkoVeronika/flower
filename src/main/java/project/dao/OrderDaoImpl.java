package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.Order;

import java.util.List;

public class OrderDaoImpl implements Dao<Order> {
    private static final Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Order order) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(order);
        logger.info("Order successfully saved. Order details: " + order);
    }

    @Override
    public void update(Order order) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(order);
        logger.info("Order successfully updated. Order details: " + order);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Order order = (Order) session.load(Order.class, new Integer(id));

        if(order!=null){
            session.delete(order);
        }
        logger.info("Order successfully removed. Order details: " + order);
    }

    @Override
    public Order getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Order order = (Order) session.load(Order.class, new Integer(id));
        logger.info("Order successfully loaded. Order details: " + order);

        return order;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Order> orderList = session.createQuery("from Order").list();

        for(Order order: orderList){
            logger.info("Order list: " + order);
        }

        return orderList;
    }
}

