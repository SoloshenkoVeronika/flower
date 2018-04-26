package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Composition {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Basic
    @Column(name = "composition", nullable = false, length = 256)
    private String composition;

    @Basic
    @Column(name = "pack", nullable = false, length = 100)
    private String pack;

    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;

    @Basic
    @Column(name = "picture", nullable = true, length = 256)
    private String picture;


    @OneToMany(mappedBy = "compositionByCompositionId")
    private Collection<CompositionOrder> compositionOrdersById;

    public Composition() {}

    public Composition(String name, String composition, String pack,
                       int amount, double price, String picture) {
        this.name = name;
        this.composition = composition;
        this.pack = pack;
        this.amount = amount;
        this.price = price;
        this.picture = picture;
    }

    public Composition(Integer id, String name, String composition, String pack,
                       int amount, double price, String picture) {
        this.id = id;
        this.name = name;
        this.composition = composition;
        this.pack = pack;
        this.amount = amount;
        this.price = price;
        this.picture = picture;
    }

    public Composition(Integer id, String name, String composition, String pack, int amount,
                       double price, String picture, Collection<CompositionOrder> compositionOrdersById) {
        this.id = id;
        this.name = name;
        this.composition = composition;
        this.pack = pack;
        this.amount = amount;
        this.price = price;
        this.picture = picture;
        this.compositionOrdersById = compositionOrdersById;
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


    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }


    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
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
        return "Composition{" + "id=" + id + ", name='" + name + '\'' + ", composition='" + composition + '\'' + ", pack='" + pack + '\'' + ", amount=" + amount + ", price=" + price + ", picture='" + picture + '\'' + ", compositionOrdersById=" + compositionOrdersById + '}';
    }*/

    @Override
    public String toString() {
        return "Composition{" + "id=" + id + ", name='" + name + '\'' + ", composition='" + composition + '\'' + ", pack='" + pack + '\'' + ", amount=" + amount + ", price=" + price + ", picture='" + picture + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Composition that = (Composition) o;

        if (amount != that.amount) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (composition != null ? !composition.equals(that.composition) : that.composition != null) return false;
        if (pack != null ? !pack.equals(that.pack) : that.pack != null) return false;
        if (picture != null ? !picture.equals(that.picture) : that.picture != null) return false;
        return compositionOrdersById != null ? compositionOrdersById.equals(that.compositionOrdersById) : that.compositionOrdersById == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (composition != null ? composition.hashCode() : 0);
        result = 31 * result + (pack != null ? pack.hashCode() : 0);
        result = 31 * result + amount;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (compositionOrdersById != null ? compositionOrdersById.hashCode() : 0);
        return result;
    }

    public Collection<CompositionOrder> getCompositionOrdersById() {
        return compositionOrdersById;
    }

    public void setCompositionOrdersById(Collection<CompositionOrder> compositionOrdersById) {
        this.compositionOrdersById = compositionOrdersById;
    }
}
