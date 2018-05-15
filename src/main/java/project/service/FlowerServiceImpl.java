package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.Flower;

import java.util.List;

public class FlowerServiceImpl implements Service<Flower> {
    private Dao<Flower> flowerDao;

    public void setFlowerDao(Dao flowerDao) {
        this.flowerDao = flowerDao;
    }

    @Override
    @Transactional
    public void add(Flower flower) {
        this.flowerDao.add(flower);
    }

    @Override
    @Transactional
    public void update(Flower flower) {
        this.flowerDao.update(flower);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.flowerDao.remove(id);
    }

    @Override
    @Transactional
    public Flower getById(int id) {
        return this.flowerDao.getById(id);
    }

    @Override
    @Transactional
    public List<Flower> list() {
        return this.flowerDao.list();
    }

    @Override
    public List<Flower> listWhere(String where) {
        return null;
    }
}
