package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.Decoration;

import java.util.List;

public class DecorationDaoImpl implements Dao<Decoration> {
    private static final Logger logger = LoggerFactory.getLogger(DecorationDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Decoration decoration) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(decoration);
        logger.info("Decoration successfully saved. Decoration details: " + decoration);
    }

    @Override
    public void update(Decoration decoration) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(decoration);
        logger.info("Decoration successfully updated. Decoration details: " + decoration);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Decoration decoration = (Decoration) session.load(Decoration.class, new Integer(id));

        if(decoration!=null){
            session.delete(decoration);
        }
        logger.info("Decoration successfully removed. Decoration details: " + decoration);
    }

    @Override
    public Decoration getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Decoration decoration = (Decoration) session.load(Decoration.class, new Integer(id));
        logger.info("Decoration successfully loaded. Decoration details: " + decoration);

        return decoration;
    }
    @Override
    public boolean getEn(Decoration userr) {

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Decoration> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Decoration> decorationList = session.createQuery("from Decoration").list();

        for(Decoration decoration: decorationList){
            logger.info("Decoration list: " + decoration);
        }

        return decorationList;
    }
}

