package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.Pack;

import java.util.List;

public class PackDaoImpl  implements Dao<Pack> {
    private static final Logger logger = LoggerFactory.getLogger(PackDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Pack pack) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(pack);
        logger.info("Pack successfully saved. Pack details: " + pack);
    }

    @Override
    public void update(Pack pack) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(pack);
        logger.info("Pack successfully update. Pack details: " + pack);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Pack pack = (Pack) session.load(Pack.class, new Integer(id));

        if(pack!=null){
            session.delete(pack);
        }
        logger.info("Pack successfully removed. Pack details: " + pack);
    }

    @Override
    public Pack getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Pack pack = (Pack) session.load(Pack.class, new Integer(id));
        logger.info("Pack successfully loaded. Pack details: " + pack);

        return pack;
    }
    @Override
    public boolean getEn(Pack userr) {

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pack> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Pack> packList = session.createQuery("from Pack").list();

        for(Pack pack: packList){
            logger.info("Pack list: " + pack);
        }

        return packList;
    }
}

