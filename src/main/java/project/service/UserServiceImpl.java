package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDao;
import project.model.User;

import java.util.List;

public class UserServiceImpl implements UserService<User> {
    private UserDao<User> userDao;

    public void setUserDao(UserDao userDao) {
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

    @Override
    @Transactional
    public boolean isAuthorized(User user) {
        return this.userDao.isAuthorized(user);
    }
}
