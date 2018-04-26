package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Decoration {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 50)
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


    @OneToMany(mappedBy = "decorationByDecorationId")
    private Collection<DecorationCustomerBouquet> decorationCustomerBouquetsById;

    public Decoration() {}

    public Decoration(String name, int amount, double price, String picture) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.picture = picture;
    }

    public Decoration(Integer id, String name, int amount, double price, String picture) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.picture = picture;
    }

    public Decoration(Integer id, String name, int amount, double price, String picture,
                      Collection<DecorationCustomerBouquet> decorationCustomerBouquetsById) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.picture = picture;
        this.decorationCustomerBouquetsById = decorationCustomerBouquetsById;
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
        return "Decoration{" + "id=" + id + ", name='" + name + '\'' + ", amount=" + amount + ", price=" + price + ", picture='" + picture + '\'' + ", decorationCustomerBouquetsById=" + decorationCustomerBouquetsById + '}';
    }*/

    @Override
    public String toString() {
        return "Decoration{" + "id=" + id + ", name='" + name + '\'' + ", amount=" + amount + ", price=" + price + ", picture='" + picture + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Decoration that = (Decoration) o;

        if (amount != that.amount) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (picture != null ? !picture.equals(that.picture) : that.picture != null) return false;
        return decorationCustomerBouquetsById != null ? decorationCustomerBouquetsById.equals(that.decorationCustomerBouquetsById) : that.decorationCustomerBouquetsById == null;
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
        result = 31 * result + (decorationCustomerBouquetsById != null ? decorationCustomerBouquetsById.hashCode() : 0);
        return result;
    }

    public Collection<DecorationCustomerBouquet> getDecorationCustomerBouquetsById() {
        return decorationCustomerBouquetsById;
    }

    public void setDecorationCustomerBouquetsById(Collection<DecorationCustomerBouquet> decorationCustomerBouquetsById) {
        this.decorationCustomerBouquetsById = decorationCustomerBouquetsById;
    }
}
