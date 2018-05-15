package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.Address;

import java.util.List;

public class AddressServiceImpl implements Service<Address> {
    private Dao<Address> addressDao;

    public void setAddressDao(Dao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    @Transactional
    public void add(Address address) {
        this.addressDao.add(address);
    }

    @Override
    @Transactional
    public void update(Address address) {
        this.addressDao.update(address);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.addressDao.remove(id);
    }

    @Override
    @Transactional
    public Address getById(int id) {
        return this.addressDao.getById(id);
    }

    @Override
    @Transactional
    public List<Address> list() {
        return this.addressDao.list();
    }

    @Override
    public List<Address> listWhere(String where) {
        return null;
    }
}

