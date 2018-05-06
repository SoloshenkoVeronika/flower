package project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import project.model.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements Dao<Address> {
    private static final Logger logger = LoggerFactory.getLogger(AddressDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Address getAddress(Address address){
        Session session = this.sessionFactory.getCurrentSession();
        ArrayList<Address> addresses = (ArrayList) session.createQuery("from Address where city = '"+address.getCity()+
                "' and street = '"+address.getStreet() + "' and house = '"+address.getHouse() +
                "' and block = '"+address.getBlock() + "' and flat = '"+address.getFlat()+"'").list();
        for(int i = 0; i <addresses.size(); i++){
            address = addresses.get(i);
        }
        return address;
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

