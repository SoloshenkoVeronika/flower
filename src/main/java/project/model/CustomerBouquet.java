package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "customer_bouquet")
public class CustomerBouquet {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "pack_id", nullable = true, insertable = false, updatable = false)
    private Integer packId;


    @ManyToOne
    @JoinColumn(name = "pack_id", referencedColumnName = "id")
    private Pack packByPackId;

    @OneToMany(mappedBy = "customerBouquetByCustomerBouquetId")
    private Collection<CustomerBouquetOrder> customerBouquetOrdersById;

    @OneToMany(mappedBy = "customerBouquetByCustomerBouquetId")
    private Collection<DecorationCustomerBouquet> decorationCustomerBouquetsById;

    @OneToMany(mappedBy = "customerBouquetByCustomerBouquetId")
    private Collection<FlowerCustomerBouquet> flowerCustomerBouquetsById;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerBouquet that = (CustomerBouquet) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (packId != null ? !packId.equals(that.packId) : that.packId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (packId != null ? packId.hashCode() : 0);
        return result;
    }

    public Pack getPackByPackId() {
        return packByPackId;
    }

    public void setPackByPackId(Pack packByPackId) {
        this.packByPackId = packByPackId;
    }

    public Collection<CustomerBouquetOrder> getCustomerBouquetOrdersById() {
        return customerBouquetOrdersById;
    }

    public void setCustomerBouquetOrdersById(Collection<CustomerBouquetOrder> customerBouquetOrdersById) {
        this.customerBouquetOrdersById = customerBouquetOrdersById;
    }

    public Collection<DecorationCustomerBouquet> getDecorationCustomerBouquetsById() {
        return decorationCustomerBouquetsById;
    }

    public void setDecorationCustomerBouquetsById(Collection<DecorationCustomerBouquet> decorationCustomerBouquetsById) {
        this.decorationCustomerBouquetsById = decorationCustomerBouquetsById;
    }

    public Collection<FlowerCustomerBouquet> getFlowerCustomerBouquetsById() {
        return flowerCustomerBouquetsById;
    }

    public void setFlowerCustomerBouquetsById(Collection<FlowerCustomerBouquet> flowerCustomerBouquetsById) {
        this.flowerCustomerBouquetsById = flowerCustomerBouquetsById;
    }
}
