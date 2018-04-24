package project.model;

import javax.persistence.*;

@Entity
@Table(name = "flower")
public class Flower{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "species", nullable = false, length = 60)
    private String species;

    @Basic
    @Column(name = "sort", nullable = false, length = 100)
    private String sort;

    @Basic
    @Column(name = "color", nullable = false, length = 30)
    private String color;

    @Basic
    @Column(name = "length", nullable = false)
    private double length;

    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;

    @Basic
    @Column(name = "price", nullable = false)
    private double price;


    @Basic
    @Column(name = "picture", nullable = true, length = 256)
    private String picture;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }


    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
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
        return "Flowers{" + "id=" + id + ", species='" + species + '\'' + ", sort='" + sort + '\'' + ", color='" + color + '\'' + ", length=" + length + ", amount=" + amount + ", price=" + price + ", picture='" + picture + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flower flower = (Flower) o;

        if (id != flower.id) return false;
        if (Double.compare(flower.length, length) != 0) return false;
        if (amount != flower.amount) return false;
        if (Double.compare(flower.price, price) != 0) return false;
        if (species != null ? !species.equals(flower.species) : flower.species != null) return false;
        if (sort != null ? !sort.equals(flower.sort) : flower.sort != null) return false;
        if (color != null ? !color.equals(flower.color) : flower.color != null) return false;
        return picture != null ? picture.equals(flower.picture) : flower.picture == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (species != null ? species.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        temp = Double.doubleToLongBits(length);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + amount;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }
}

