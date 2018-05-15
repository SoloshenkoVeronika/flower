package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.dao.OrderDaoImpl;
import project.model.Order;

import java.util.List;

public class OrderServiceImpl implements Service<Order> {
    private Dao<Order> orderDao;

    public void setOrderDao(Dao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    @Transactional
    public void add(Order order) {
        this.orderDao.add(order);
    }

    @Override
    @Transactional
    public void update(Order order) {
        this.orderDao.update(order);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.orderDao.remove(id);
    }

    @Override
    @Transactional
    public Order getById(int id) {
        return this.orderDao.getById(id);
    }

    @Override
    @Transactional
    public List<Order> list() {
        return this.orderDao.list();
    }

    @Override
    @Transactional
    public List<Order> listWhere(String where) {
        return ((OrderDaoImpl)this.orderDao).listWhere(where);
    }
}
