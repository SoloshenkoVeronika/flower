package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.CustomerBouquetOrder;

import java.util.List;

public class CustomerBouquetOrderServiceImpl implements Service<CustomerBouquetOrder> {
    private Dao<CustomerBouquetOrder> customerBouquetOrderDao;

    public void setCustomerBouquetOrderDao(Dao customerBouquetDao) {
        this.customerBouquetOrderDao = customerBouquetDao;
    }

    @Override
    @Transactional
    public void add(CustomerBouquetOrder customerBouquetOrder) {
        this.customerBouquetOrderDao.add(customerBouquetOrder);
    }

    @Override
    @Transactional
    public void update(CustomerBouquetOrder customerBouquetOrder) {
        this.customerBouquetOrderDao.update(customerBouquetOrder);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.customerBouquetOrderDao.remove(id);
    }

    @Override
    @Transactional
    public CustomerBouquetOrder getById(int id) {
        return this.customerBouquetOrderDao.getById(id);
    }

    @Override
    @Transactional
    public List<CustomerBouquetOrder> list() {
        return this.customerBouquetOrderDao.list();
    }

    @Override
    public List<CustomerBouquetOrder> listWhere(String where) {
        return null;
    }
}
