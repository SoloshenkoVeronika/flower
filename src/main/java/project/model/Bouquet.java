package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Bouquet {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Basic
    @Column(name = "composition", nullable = false, length = 256)
    private String composition;

    @Basic
    @Column(name = "height", nullable = false)
    private double height;

    @Basic
    @Column(name = "diameter", nullable = false)
    private double diameter;

    @Basic
    @Column(name = "weight", nullable = false, precision = 0)
    private double weight;

    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;

    @Basic
    @Column(name = "picture", nullable = true, length = 256)
    private String picture;


    @OneToMany(mappedBy = "bouquetByBouquetId")
    private Collection<BouquetOrder> bouquetOrdersById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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

    @Override
    public String toString() {
        return "Bouquet{" + "id=" + id + ", name='" + name + '\'' + ", composition='" + composition + '\'' + ", height=" + height + ", diameter=" + diameter + ", weight=" + weight + ", amount=" + amount + ", price=" + price + ", picture='" + picture + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bouquet bouquet = (Bouquet) o;

        if (id != bouquet.id) return false;
        if (Double.compare(bouquet.height, height) != 0) return false;
        if (Double.compare(bouquet.diameter, diameter) != 0) return false;
        if (Double.compare(bouquet.weight, weight) != 0) return false;
        if (amount != bouquet.amount) return false;
        if (Double.compare(bouquet.price, price) != 0) return false;
        if (name != null ? !name.equals(bouquet.name) : bouquet.name != null) return false;
        if (composition != null ? !composition.equals(bouquet.composition) : bouquet.composition != null) return false;
        return picture != null ? picture.equals(bouquet.picture) : bouquet.picture == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (composition != null ? composition.hashCode() : 0);
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(diameter);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + amount;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }

    public Collection<BouquetOrder> getBouquetOrdersById() {
        return bouquetOrdersById;
    }

    public void setBouquetOrdersById(Collection<BouquetOrder> bouquetOrdersById) {
        this.bouquetOrdersById = bouquetOrdersById;
    }
}
