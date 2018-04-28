package project.service;

import org.springframework.transaction.annotation.Transactional;
import project.dao.Dao;
import project.model.Decoration;

import java.util.List;

public class DecorationServiceImpl implements Service<Decoration> {
    private Dao<Decoration> decorationDao;

    public void setDecorationDao(Dao decorationDao) {
        this.decorationDao = decorationDao;
    }

    @Override
    @Transactional
    public void add(Decoration decoration) {
        this.decorationDao.add(decoration);
    }

    @Override
    @Transactional
    public void update(Decoration decoration) {
        this.decorationDao.update(decoration);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.decorationDao.remove(id);
    }

    @Override
    @Transactional
    public Decoration getById(int id) {
        return this.decorationDao.getById(id);
    }

    @Override
    @Transactional
    public List<Decoration> list() {
        return this.decorationDao.list();
    }
}
