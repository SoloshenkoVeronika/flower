package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Pack {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;

    @Basic
    @Column(name = "picture", nullable = true, length = 256)
    private String picture;


    @OneToMany(mappedBy = "packByPackId")
    private Collection<CustomerBouquet> customerBouquetsById;

    public Pack() {}

    public Pack(String name, int amount, double price, String picture) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.picture = picture;
    }

    public Pack(Integer id, String name, int amount, double price, String picture) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.picture = picture;
    }

    public Pack(Integer id, String name, int amount, double price, String picture,
                Collection<CustomerBouquet> customerBouquetsById) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.picture = picture;
        this.customerBouquetsById = customerBouquetsById;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    /*@Override
    public String toString() {
        return "Pack{" + "id=" + id + ", name='" + name + '\'' + ", amount=" + amount + ", price=" + price + ", picture='" + picture + '\'' + ", customerBouquetsById=" + customerBouquetsById + '}';
    }*/

    @Override
    public String toString() {
        return "Pack{" + "id=" + id + ", name='" + name + '\'' + ", amount=" + amount + ", price=" + price + ", picture='" + picture + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pack pack = (Pack) o;

        if (amount != pack.amount) return false;
        if (Double.compare(pack.price, price) != 0) return false;
        if (id != null ? !id.equals(pack.id) : pack.id != null) return false;
        if (name != null ? !name.equals(pack.name) : pack.name != null) return false;
        if (picture != null ? !picture.equals(pack.picture) : pack.picture != null) return false;
        return customerBouquetsById != null ? customerBouquetsById.equals(pack.customerBouquetsById) : pack.customerBouquetsById == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + amount;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (customerBouquetsById != null ? customerBouquetsById.hashCode() : 0);
        return result;
    }

    public Collection<CustomerBouquet> getCustomerBouquetsById() {
        return customerBouquetsById;
    }

    public void setCustomerBouquetsById(Collection<CustomerBouquet> customerBouquetsById) {
        this.customerBouquetsById = customerBouquetsById;
    }
}
