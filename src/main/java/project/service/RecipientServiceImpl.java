package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.Recipient;

import java.util.List;

public class RecipientServiceImpl implements Service<Recipient> {
    private Dao<Recipient> recipientDao;

    public void setRecipientDao(Dao recipientDao) {
        this.recipientDao = recipientDao;
    }

    @Override
    @Transactional
    public void add(Recipient recipient) {
        this.recipientDao.add(recipient);
    }

    @Override
    @Transactional
    public void update(Recipient recipient) {
        this.recipientDao.update(recipient);
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

    @Override
    public List<Recipient> listWhere(String where) {
        return null;
    }
}

