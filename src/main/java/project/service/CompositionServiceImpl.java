package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.Composition;

import java.util.List;

public class CompositionServiceImpl implements Service<Composition> {
    private Dao<Composition> compositionDao;

    public void setCompositionDao(Dao compositionDao) {
        this.compositionDao = compositionDao;
    }

    @Override
    @Transactional
    public void add(Composition composition) {
        this.compositionDao.add(composition);
    }

    @Override
    @Transactional
    public void update(Composition composition) {
        this.compositionDao.update(composition);
    }

    @Override
    @Transactional
    public boolean getEn(Composition composition) {
        return  this.compositionDao.getEn(composition);
    }


    @Override
    @Transactional
    public void remove(int id) {
        this.compositionDao.remove(id);
    }

    @Override
    @Transactional
    public Composition getById(int id) {
        return this.compositionDao.getById(id);
    }

    @Override
    @Transactional
    public List<Composition> list() {
        return this.compositionDao.list();
    }
}

