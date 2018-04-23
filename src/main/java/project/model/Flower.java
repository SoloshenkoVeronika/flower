package project.model;

import javax.persistence.*;

@Entity
public class Flower {
    private Integer id;
    private String species;
    private String sort;
    private String color;
    private Integer length;
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
    @Column(name = "species", nullable = false, length = 60)
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Basic
    @Column(name = "sort", nullable = false, length = 100)
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "color", nullable = false, length = 30)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "length", nullable = false, precision = 0)
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
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

        Flower flower = (Flower) o;

        if (id != null ? !id.equals(flower.id) : flower.id != null) return false;
        if (species != null ? !species.equals(flower.species) : flower.species != null) return false;
        if (sort != null ? !sort.equals(flower.sort) : flower.sort != null) return false;
        if (color != null ? !color.equals(flower.color) : flower.color != null) return false;
        if (length != null ? !length.equals(flower.length) : flower.length != null) return false;
        if (amount != null ? !amount.equals(flower.amount) : flower.amount != null) return false;
        if (price != null ? !price.equals(flower.price) : flower.price != null) return false;
        if (picture != null ? !picture.equals(flower.picture) : flower.picture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (species != null ? species.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }
}
