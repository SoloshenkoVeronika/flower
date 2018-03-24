package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.Flower;

import java.util.List;

public class FlowerDaoImpl  implements Dao<Flower> {
    private static final Logger logger = LoggerFactory.getLogger(FlowerDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Flower flower) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(flower);
        logger.info("Flower successfully saved. Flower details: " + flower);
    }

    @Override
    public void update(Flower flower) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(flower);
        logger.info("Flower successfully update. Flower details: " + flower);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Flower flower = (Flower) session.load(Flower.class, new Integer(id));

        if(flower!=null){
            session.delete(flower);
        }
        logger.info("Flower successfully removed. Flower details: " + flower);
    }

    @Override
    public Flower getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Flower flower = (Flower) session.load(Flower.class, new Integer(id));
        logger.info("Flower successfully loaded. Flower details: " + flower);

        return flower;
    }
    @Override
    public boolean getEn(Flower userr) {

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Flower> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Flower> flowerList = session.createQuery("from Flower").list();

        for(Flower flower: flowerList){
            logger.info("Flower list: " + flower);
        }

        return flowerList;
    }
}

