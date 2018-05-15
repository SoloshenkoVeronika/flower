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
    public void add(BouquetOrder bouquetOrder) {
        this.bouquetOrderDao.add(bouquetOrder);
    }

    @Override
    @Transactional
    public void update(BouquetOrder bouquetOrder) {
        this.bouquetOrderDao.update(bouquetOrder);
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

    @Override
    public List<BouquetOrder> listWhere(String where) {
        return null;
    }
}
