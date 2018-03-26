package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.Composition;

import java.util.List;

public class CompositionDaoImpl implements Dao<Composition> {
    private static final Logger logger = LoggerFactory.getLogger(CompositionDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Composition composition) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(composition);
        logger.info("Composition successfully saved. Composition details: " + composition);
    }

    @Override
    public void update(Composition composition) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(composition);
        logger.info("Composition successfully update. Composition details: " + composition);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Composition composition = (Composition) session.load(Composition.class, new Integer(id));

        if(composition!=null){
            session.delete(composition);
        }
        logger.info("Composition successfully removed. Composition details: " + composition);
    }

    @Override
    public Composition getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Composition composition = (Composition) session.load(Composition.class, new Integer(id));
        logger.info("Composition successfully loaded. Composition details: " + composition);

        return composition;
    }
    @Override
    public boolean getEn(Composition userr) {

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Composition> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Composition> compositionList = session.createQuery("from Composition").list();

        for(Composition composition: compositionList){
            logger.info("Composition list: " + composition);
        }

        return compositionList;
    }
}


