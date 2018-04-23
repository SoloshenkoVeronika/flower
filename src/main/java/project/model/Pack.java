package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Pack {
    private Integer id;
    private String name;
    private Integer amount;
    private Double price;
    private String picture;
    private Collection<CustomerBouquet> customerBouquetsById;

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

        Pack pack = (Pack) o;

        if (id != null ? !id.equals(pack.id) : pack.id != null) return false;
        if (name != null ? !name.equals(pack.name) : pack.name != null) return false;
        if (amount != null ? !amount.equals(pack.amount) : pack.amount != null) return false;
        if (price != null ? !price.equals(pack.price) : pack.price != null) return false;
        if (picture != null ? !picture.equals(pack.picture) : pack.picture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "packByPackId")
    public Collection<CustomerBouquet> getCustomerBouquetsById() {
        return customerBouquetsById;
    }

    public void setCustomerBouquetsById(Collection<CustomerBouquet> customerBouquetsById) {
        this.customerBouquetsById = customerBouquetsById;
    }
}
