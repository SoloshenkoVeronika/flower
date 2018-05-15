package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.CompositionOrder;

import java.util.List;

public class CompositionOrderServiceImpl implements Service<CompositionOrder> {
    private Dao<CompositionOrder> compositionOrderDao;

    public void setCompositionOrderDao(Dao compositionDao) {
        this.compositionOrderDao = compositionDao;
    }

    @Override
    @Transactional
    public void add(CompositionOrder compositionOrder) {
        this.compositionOrderDao.add(compositionOrder);
    }

    @Override
    @Transactional
    public void update(CompositionOrder compositionOrder) {
        this.compositionOrderDao.update(compositionOrder);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.compositionOrderDao.remove(id);
    }

    @Override
    @Transactional
    public CompositionOrder getById(int id) {
        return this.compositionOrderDao.getById(id);
    }

    @Override
    @Transactional
    public List<CompositionOrder> list() {
        return this.compositionOrderDao.list();
    }

    @Override
    public List<CompositionOrder> listWhere(String where) {
        return null;
    }
}
