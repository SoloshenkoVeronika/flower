package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.Bouquet;

import java.util.List;

public class BouquetServiceImpl implements Service<Bouquet> {
    private Dao<Bouquet> bouquetDao;

    public void setBouquetDao(Dao bouquetDao) {
        this.bouquetDao = bouquetDao;
    }

    @Override
    @Transactional
    public void add(Bouquet bouquet) {
        this.bouquetDao.add(bouquet);
    }

    @Override
    @Transactional
    public void update(Bouquet bouquet) {
        this.bouquetDao.update(bouquet);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.bouquetDao.remove(id);
    }

    @Override
    @Transactional
    public Bouquet getById(int id) {
        return this.bouquetDao.getById(id);
    }

    @Override
    @Transactional
    public List<Bouquet> list() {
        return this.bouquetDao.list();
    }

    @Override
    public List<Bouquet> listWhere(String where) {
        return null;
    }
}

