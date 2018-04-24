package project.service;

import project.dao.Dao;
import org.springframework.transaction.annotation.Transactional;
import project.model.User;


import java.util.List;

public class UserServiceImpl implements Service<User> {
    private Dao<User> userDao;

    public void setUserDao(Dao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void add(User user) {
        this.userDao.add(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        this.userDao.update(user);
    }

    @Override
    @Transactional
    public boolean getEn(User user) {
        return  this.userDao.getEn(user);
    }


    @Override
    @Transactional
    public void remove(int id) {
        this.userDao.remove(id);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return this.userDao.getById(id);
    }

    @Override
    @Transactional
    public List<User> list() {
        return this.userDao.list();
    }
}
