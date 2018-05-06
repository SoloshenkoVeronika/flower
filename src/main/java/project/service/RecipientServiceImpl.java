package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.Recipient;

import java.util.List;

public class RecipientServiceImpl implements Service<Recipient> {
    private Dao<Recipient> recipientDao;

    public void setRecipientDao(Dao bouquetDao) {
        this.recipientDao = bouquetDao;
    }

    @Override
    @Transactional
    public void add(Recipient bouquet) {
        this.recipientDao.add(bouquet);
    }

    @Override
    @Transactional
    public void update(Recipient bouquet) {
        this.recipientDao.update(bouquet);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.recipientDao.remove(id);
    }

    @Override
    @Transactional
    public Recipient getById(int id) {
        return this.recipientDao.getById(id);
    }

    @Override
    @Transactional
    public List<Recipient> list() {
        return this.recipientDao.list();
    }
}

