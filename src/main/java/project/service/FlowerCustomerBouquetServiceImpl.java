package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.FlowerCustomerBouquet;

import java.util.List;

public class FlowerCustomerBouquetServiceImpl implements Service<FlowerCustomerBouquet> {
    private Dao<FlowerCustomerBouquet> flowerCustomerBouquetDao;

    public void setFlowerCustomerBouquetDao(Dao flowerDao) {
        this.flowerCustomerBouquetDao = flowerDao;
    }

    @Override
    @Transactional
    public void add(FlowerCustomerBouquet flowerCustomerBouquet) {
        this.flowerCustomerBouquetDao.add(flowerCustomerBouquet);
    }

    @Override
    @Transactional
    public void update(FlowerCustomerBouquet flowerCustomerBouquet) {
        this.flowerCustomerBouquetDao.update(flowerCustomerBouquet);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.flowerCustomerBouquetDao.remove(id);
    }

    @Override
    @Transactional
    public FlowerCustomerBouquet getById(int id) {
        return this.flowerCustomerBouquetDao.getById(id);
    }

    @Override
    @Transactional
    public List<FlowerCustomerBouquet> list() {
        return this.flowerCustomerBouquetDao.list();
    }

    @Override
    public List<FlowerCustomerBouquet> listWhere(String where) {
        return null;
    }
}
