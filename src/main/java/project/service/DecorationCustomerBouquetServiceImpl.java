package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.DecorationCustomerBouquet;

import java.util.List;

public class DecorationCustomerBouquetServiceImpl implements Service<DecorationCustomerBouquet> {
    private Dao<DecorationCustomerBouquet> flowerCustomerBouquetDao;

    public void setDecorationCustomerBouquetDao(Dao flowerDao) {
        this.flowerCustomerBouquetDao = flowerDao;
    }

    @Override
    @Transactional
    public void add(DecorationCustomerBouquet decorationCustomerBouquet) {
        this.flowerCustomerBouquetDao.add(decorationCustomerBouquet);
    }

    @Override
    @Transactional
    public void update(DecorationCustomerBouquet decorationCustomerBouquet) {
        this.flowerCustomerBouquetDao.update(decorationCustomerBouquet);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.flowerCustomerBouquetDao.remove(id);
    }

    @Override
    @Transactional
    public DecorationCustomerBouquet getById(int id) {
        return this.flowerCustomerBouquetDao.getById(id);
    }

    @Override
    @Transactional
    public List<DecorationCustomerBouquet> list() {
        return this.flowerCustomerBouquetDao.list();
    }

    @Override
    public List<DecorationCustomerBouquet> listWhere(String where) {
        return null;
    }
}
