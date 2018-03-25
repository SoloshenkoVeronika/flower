package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.Bouquet;

import java.util.List;

public class BouquetDaoImpl implements Dao<Bouquet>{
    private static final Logger logger = LoggerFactory.getLogger(BouquetDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Bouquet bouquet) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(bouquet);
        logger.info("Bouquet successfully saved. Bouquet details: " + bouquet);
    }

    @Override
    public void update(Bouquet bouquet) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(bouquet);
        logger.info("Bouquet successfully update. Bouquet details: " + bouquet);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Bouquet bouquet = (Bouquet) session.load(Bouquet.class, new Integer(id));

        if(bouquet!=null){
            session.delete(bouquet);
        }
        logger.info("Bouquet successfully removed. Bouquet details: " + bouquet);
    }

    @Override
    public Bouquet getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Bouquet bouquet = (Bouquet) session.load(Bouquet.class, new Integer(id));
        logger.info("Bouquet successfully loaded. Bouquet details: " + bouquet);

        return bouquet;
    }
    @Override
    public boolean getEn(Bouquet bouquet) {

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Bouquet> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Bouquet> bouquetList = session.createQuery("from Bouquet").list();

        for(Bouquet bouquet: bouquetList){
            logger.info("Bouquet list: " + bouquet);
        }

        return bouquetList;
    }
}

