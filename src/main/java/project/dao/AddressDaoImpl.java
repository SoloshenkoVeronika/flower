package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.Address;

import java.util.List;

public class AddressDaoImpl implements Dao<Address> {
    private static final Logger logger = LoggerFactory.getLogger(AddressDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Address address) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(address);
        logger.info("Address successfully saved. Address details: " + address);
    }

    @Override
    public void update(Address address) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(address);
        logger.info("Address successfully updated. Address details: " + address);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Address address = (Address) session.load(Address.class, new Integer(id));

        if(address!=null){
            session.delete(address);
        }
        logger.info("Address successfully removed. Address details: " + address);
    }

    @Override
    public Address getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Address address = (Address) session.load(Address.class, new Integer(id));
        logger.info("Address successfully loaded. Address details: " + address);

        return address;
    }

    @Override
    public boolean getEn(Address address) {

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Address> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Address> addressList = session.createQuery("from Address").list();

        for(Address address: addressList){
            logger.info("Address list: " + address);
        }

        return addressList;
    }
}

