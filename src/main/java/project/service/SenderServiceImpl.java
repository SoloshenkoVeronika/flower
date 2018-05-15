package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.Sender;

import java.util.List;

public class SenderServiceImpl implements Service<Sender> {
    private Dao<Sender> senderDao;

    public void setSenderDao(Dao senderDao) {
        this.senderDao = senderDao;
    }

    @Override
    @Transactional
    public void add(Sender sender) {
        this.senderDao.add(sender);
    }

    @Override
    @Transactional
    public void update(Sender sender) {
        this.senderDao.update(sender);
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

    @Override
    public List<Sender> listWhere(String where) {
        return null;
    }
}

