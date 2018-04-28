package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.Pack;

import java.util.List;

public class PackServiceImpl implements Service<Pack> {
    private Dao<Pack> packDao;

    public void setPackDao(Dao packDao) {
        this.packDao = packDao;
    }

    @Override
    @Transactional
    public void add(Pack pack) {
        this.packDao.add(pack);
    }

    @Override
    @Transactional
    public void update(Pack pack) {
        this.packDao.update(pack);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.packDao.remove(id);
    }

    @Override
    @Transactional
    public Pack getById(int id) {
        return this.packDao.getById(id);
    }

    @Override
    @Transactional
    public List<Pack> list() {
        return this.packDao.list();
    }
}


