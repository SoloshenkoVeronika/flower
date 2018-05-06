package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "customer_bouquet")
public class CustomerBouquet {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "pack_id", nullable = true, insertable = false, updatable = false)
    private Integer packId;


    @ManyToOne
    @JoinColumn(name = "pack_id", referencedColumnName = "id")
    private Pack packByPackId;

    @OneToMany(mappedBy = "customerBouquetByCustomerBouquetId", fetch = FetchType.EAGER)
    private Collection<CustomerBouquetOrder> customerBouquetOrdersById;

    @OneToMany(mappedBy = "customerBouquetByCustomerBouquetId", fetch = FetchType.EAGER)
    private Collection<DecorationCustomerBouquet> decorationCustomerBouquetsById;

    @OneToMany(mappedBy = "customerBouquetByCustomerBouquetId", fetch = FetchType.EAGER)
    private Collection<FlowerCustomerBouquet> flowerCustomerBouquetsById;

    public CustomerBouquet() {}

    public CustomerBouquet(Integer packId) {
        this.packId = packId;
    }

    public CustomerBouquet(Integer id, Integer packId) {
        this.id = id;
        this.packId = packId;
    }

    public CustomerBouquet(Integer id, Integer packId, Pack packByPackId,
                           Collection<CustomerBouquetOrder> customerBouquetOrdersById,
                           Collection<DecorationCustomerBouquet> decorationCustomerBouquetsById,
                           Collection<FlowerCustomerBouquet> flowerCustomerBouquetsById) {
        this.id = id;
        this.packId = packId;
        this.packByPackId = packByPackId;
        this.customerBouquetOrdersById = customerBouquetOrdersById;
        this.decorationCustomerBouquetsById = decorationCustomerBouquetsById;
        this.flowerCustomerBouquetsById = flowerCustomerBouquetsById;
    }

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

    /*@Override
    public String toString() {
        return "CustomerBouquet{" + "id=" + id + ", packId=" + packId + ", packByPackId=" + packByPackId + ", customerBouquetOrdersById=" + customerBouquetOrdersById + ", decorationCustomerBouquetsById=" + decorationCustomerBouquetsById + ", flowerCustomerBouquetsById=" + flowerCustomerBouquetsById + '}';
    }*/

    @Override
    public String toString() {
        return "CustomerBouquet{" + "id=" + id + ", packId=" + packId + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerBouquet that = (CustomerBouquet) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (packId != null ? !packId.equals(that.packId) : that.packId != null) return false;
        if (packByPackId != null ? !packByPackId.equals(that.packByPackId) : that.packByPackId != null) return false;
        if (customerBouquetOrdersById != null ? !customerBouquetOrdersById.equals(that.customerBouquetOrdersById) : that.customerBouquetOrdersById != null)
            return false;
        if (decorationCustomerBouquetsById != null ? !decorationCustomerBouquetsById.equals(that.decorationCustomerBouquetsById) : that.decorationCustomerBouquetsById != null)
            return false;
        return flowerCustomerBouquetsById != null ? flowerCustomerBouquetsById.equals(that.flowerCustomerBouquetsById) : that.flowerCustomerBouquetsById == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (packId != null ? packId.hashCode() : 0);
        result = 31 * result + (packByPackId != null ? packByPackId.hashCode() : 0);
        result = 31 * result + (customerBouquetOrdersById != null ? customerBouquetOrdersById.hashCode() : 0);
        result = 31 * result + (decorationCustomerBouquetsById != null ? decorationCustomerBouquetsById.hashCode() : 0);
        result = 31 * result + (flowerCustomerBouquetsById != null ? flowerCustomerBouquetsById.hashCode() : 0);
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
