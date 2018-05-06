package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.Sender;

import java.util.List;

public class SenderServiceImpl implements Service<Sender> {
    private Dao<Sender> senderDao;

    public void setSenderDao(Dao bouquetDao) {
        this.senderDao = bouquetDao;
    }

    @Override
    @Transactional
    public void add(Sender bouquet) {
        this.senderDao.add(bouquet);
    }

    @Override
    @Transactional
    public void update(Sender bouquet) {
        this.senderDao.update(bouquet);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.senderDao.remove(id);
    }

    @Override
    @Transactional
    public Sender getById(int id) {
        return this.senderDao.getById(id);
    }

    @Override
    @Transactional
    public List<Sender> list() {
        return this.senderDao.list();
    }
}

