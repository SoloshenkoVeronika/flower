package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Address {
    private Integer id;
    private String city;
    private String street;
    private Integer house;
    private Integer block;
    private Integer flat;
    private Collection<Order> ordersById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "street", nullable = false, length = 256)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "house", nullable = false)
    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    @Basic
    @Column(name = "block", nullable = false)
    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    @Basic
    @Column(name = "flat", nullable = false)
    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != null ? !id.equals(address.id) : address.id != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (house != null ? !house.equals(address.house) : address.house != null) return false;
        if (block != null ? !block.equals(address.block) : address.block != null) return false;
        if (flat != null ? !flat.equals(address.flat) : address.flat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (block != null ? block.hashCode() : 0);
        result = 31 * result + (flat != null ? flat.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Order> ordersById) {
        this.ordersById = ordersById;
    }
}
