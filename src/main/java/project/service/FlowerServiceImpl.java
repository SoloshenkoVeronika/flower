package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.Flower;

import java.util.List;

public class FlowerServiceImpl implements Service<Flower> {
    private Dao<Flower> flowerDao;

    public void setFlowerDao(Dao userDao) {
        this.flowerDao = userDao;
    }

    @Override
    @Transactional
    public void add(Flower user) {
        this.flowerDao.add(user);
    }

    @Override
    @Transactional
    public void update(Flower user) {
        this.flowerDao.update(user);
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
}
