package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.CustomerBouquet;

import java.util.List;

public class CustomerBouquetServiceImpl implements Service<CustomerBouquet> {
    private Dao<CustomerBouquet> customerBouquetDao;

    public void setCustomerBouquetDao(Dao customerBouquetDao) {
        this.customerBouquetDao = customerBouquetDao;
    }

    @Override
    @Transactional
    public void add(CustomerBouquet customerBouquet) {
        this.customerBouquetDao.add(customerBouquet);
    }

    @Override
    @Transactional
    public void update(CustomerBouquet customerBouquet) {
        this.customerBouquetDao.update(customerBouquet);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.customerBouquetDao.remove(id);
    }

    @Override
    @Transactional
    public CustomerBouquet getById(int id) {
        return this.customerBouquetDao.getById(id);
    }

    @Override
    @Transactional
    public List<CustomerBouquet> list() {
        return this.customerBouquetDao.list();
    }

    @Override
    public List<CustomerBouquet> listWhere(String where) {
        return null;
    }
}
