package project.model;

import javax.persistence.*;

@Entity
public class Bouquet {
    private Integer id;
    private String name;
    private String composition;
    private Integer height;
    private Integer diameter;
    private Double weight;
    private Integer amount;
    private Double price;
    private String picture;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 60)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "composition", nullable = false, length = 256)
    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    @Basic
    @Column(name = "height", nullable = false, precision = 0)
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Basic
    @Column(name = "diameter", nullable = false, precision = 0)
    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    @Basic
    @Column(name = "weight", nullable = false, precision = 0)
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "amount", nullable = false)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "picture", nullable = true, length = 256)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bouquet bouquet = (Bouquet) o;

        if (id != null ? !id.equals(bouquet.id) : bouquet.id != null) return false;
        if (name != null ? !name.equals(bouquet.name) : bouquet.name != null) return false;
        if (composition != null ? !composition.equals(bouquet.composition) : bouquet.composition != null) return false;
        if (height != null ? !height.equals(bouquet.height) : bouquet.height != null) return false;
        if (diameter != null ? !diameter.equals(bouquet.diameter) : bouquet.diameter != null) return false;
        if (weight != null ? !weight.equals(bouquet.weight) : bouquet.weight != null) return false;
        if (amount != null ? !amount.equals(bouquet.amount) : bouquet.amount != null) return false;
        if (price != null ? !price.equals(bouquet.price) : bouquet.price != null) return false;
        if (picture != null ? !picture.equals(bouquet.picture) : bouquet.picture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (composition != null ? composition.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (diameter != null ? diameter.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }
}
