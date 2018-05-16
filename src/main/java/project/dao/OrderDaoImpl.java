package project.dao;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderDaoImpl implements Dao<Order> {
    private static final Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Order getOrder(Order order){
        Session session = this.sessionFactory.getCurrentSession();
        ArrayList<Order> orders = (ArrayList) session.createQuery("from Order where date = '"+order.getDate()+
                "' and postcard = '"+order.getPostcard() + "' and additionalInf = '"+order.getAdditionalInf() +
                "' and payment = '"+order.getPayment() + "' and cost = '"+order.getCost()+"'").list();
        for(int i = 0; i <orders.size(); i++){
            order = orders.get(i);
        }
        return order;
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
        Order order = null;
        try {
            order = (Order) session.load(Order.class, new Integer(id));
        } catch (ObjectNotFoundException e){
            logger.info("Order not found");
            return order;
        }
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

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> listWhere(String where) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Order> orderList = session.createQuery("from Order where " + where).list();

        for(Order order: orderList){
            logger.info("Order list: " + order);
        }

        return orderList;
    }
}

