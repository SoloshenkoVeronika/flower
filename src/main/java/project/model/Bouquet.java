package project.model;

import javax.persistence.*;

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
    private float height;

    @Basic
    @Column(name = "diameter", nullable = false)
    private float diameter;

    @Basic
    @Column(name = "weight", nullable = false, precision = 0)
    private float weight;

    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private float price;

    @Basic
    @Column(name = "picture", nullable = true, length = 256)
    private String picture;


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


    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }


    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }


    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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

}
