package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.FlowerOrder;

import java.util.List;

public class FlowerOrderServiceImpl implements Service<FlowerOrder> {
    private Dao<FlowerOrder> flowerOrderDao;

    public void setFlowerOrderDao(Dao flowerDao) {
        this.flowerOrderDao = flowerDao;
    }

    @Override
    @Transactional
    public void add(FlowerOrder user) {
        this.flowerOrderDao.add(user);
    }

    @Override
    @Transactional
    public void update(FlowerOrder user) {
        this.flowerOrderDao.update(user);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.flowerOrderDao.remove(id);
    }

    @Override
    @Transactional
    public FlowerOrder getById(int id) {
        return this.flowerOrderDao.getById(id);
    }

    @Override
    @Transactional
    public List<FlowerOrder> list() {
        return this.flowerOrderDao.list();
    }
}
