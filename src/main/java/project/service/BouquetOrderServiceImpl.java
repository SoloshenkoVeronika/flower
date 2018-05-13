package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.BouquetOrder;

import java.util.List;

public class BouquetOrderServiceImpl implements Service<BouquetOrder> {
    private Dao<BouquetOrder> bouquetOrderDao;

    public void setBouquetOrderDao(Dao bouquetDao) {
        this.bouquetOrderDao = bouquetDao;
    }

    @Override
    @Transactional
    public void add(BouquetOrder user) {
        this.bouquetOrderDao.add(user);
    }

    @Override
    @Transactional
    public void update(BouquetOrder user) {
        this.bouquetOrderDao.update(user);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.bouquetOrderDao.remove(id);
    }

    @Override
    @Transactional
    public BouquetOrder getById(int id) {
        return this.bouquetOrderDao.getById(id);
    }

    @Override
    @Transactional
    public List<BouquetOrder> list() {
        return this.bouquetOrderDao.list();
    }
}
