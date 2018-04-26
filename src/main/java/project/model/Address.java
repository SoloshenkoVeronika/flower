package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Basic
    @Column(name = "street", nullable = false, length = 50)
    private String street;

    @Basic
    @Column(name = "house", nullable = false)
    private int house;

    @Basic
    @Column(name = "block", nullable = false)
    private int block;

    @Basic
    @Column(name = "flat", nullable = false)
    private int flat;


    @OneToMany(mappedBy = "addressByAddressId")
    private Collection<Order> ordersById;

    public Address() {}

    public Address(String city, String street, int house, int block, int flat) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.block = block;
        this.flat = flat;
    }

    public Address(Integer id, String city, String street, int house, int block, int flat) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.block = block;
        this.flat = flat;
    }

    public Address(Integer id, String city, String street, int house, int block,
                   int flat, Collection<Order> ordersById) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.block = block;
        this.flat = flat;
        this.ordersById = ordersById;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    /*@Override
    public String toString() {
        return "Address{" + "id=" + id + ", city='" + city + '\'' + ", street='" + street + '\'' + ", house=" + house + ", block=" + block + ", flat=" + flat + ", ordersById=" + ordersById + '}';
    }*/

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", city='" + city + '\'' + ", street='" + street + '\'' + ", house=" + house + ", block=" + block + ", flat=" + flat + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (house != address.house) return false;
        if (block != address.block) return false;
        if (flat != address.flat) return false;
        if (id != null ? !id.equals(address.id) : address.id != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        return ordersById != null ? ordersById.equals(address.ordersById) : address.ordersById == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + house;
        result = 31 * result + block;
        result = 31 * result + flat;
        result = 31 * result + (ordersById != null ? ordersById.hashCode() : 0);
        return result;
    }

    public Collection<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Order> ordersById) {
        this.ordersById = ordersById;
    }
}
