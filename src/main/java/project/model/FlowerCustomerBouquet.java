package project.model;

import javax.persistence.*;

@Entity
@Table(name = "flower_customer_bouquet", schema = "flowers", catalog = "")
public class FlowerCustomerBouquet {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "flower_id", nullable = true, insertable = false, updatable = false)
    private Integer flowerId;

    @Basic
    @Column(name = "customer_bouquet_id", nullable = true, insertable = false, updatable = false)
    private Integer customerBouquetId;

    @Basic
    @Column(name = "quantity", nullable = true)
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "flower_id", referencedColumnName = "id")
    private Flower flowerByFlowerId;

    @ManyToOne
    @JoinColumn(name = "customer_bouquet_id", referencedColumnName = "id")
    private CustomerBouquet customerBouquetByCustomerBouquetId;

    public FlowerCustomerBouquet() {}

    public FlowerCustomerBouquet(Integer flowerId, Integer customerBouquetId, int quantity) {
        this.flowerId = flowerId;
        this.customerBouquetId = customerBouquetId;
        this.quantity = quantity;
    }

    public FlowerCustomerBouquet(Integer id, Integer flowerId, Integer customerBouquetId, int quantity) {
        this.id = id;
        this.flowerId = flowerId;
        this.customerBouquetId = customerBouquetId;
        this.quantity = quantity;
    }

    public FlowerCustomerBouquet(Integer id, Integer flowerId, Integer customerBouquetId, int quantity,
                                 Flower flowerByFlowerId, CustomerBouquet customerBouquetByCustomerBouquetId) {
        this.id = id;
        this.flowerId = flowerId;
        this.customerBouquetId = customerBouquetId;
        this.quantity = quantity;
        this.flowerByFlowerId = flowerByFlowerId;
        this.customerBouquetByCustomerBouquetId = customerBouquetByCustomerBouquetId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(Integer flowerId) {
        this.flowerId = flowerId;
    }

    public Integer getCustomerBouquetId() {
        return customerBouquetId;
    }

    public void setCustomerBouquetId(Integer customerBouquetId) {
        this.customerBouquetId = customerBouquetId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /*@Override
    public String toString() {
        return "FlowerCustomerBouquet{" + "id=" + id + ", flowerId=" + flowerId + ", customerBouquetId=" + customerBouquetId + ", quantity=" + quantity + ", flowerByFlowerId=" + flowerByFlowerId + ", customerBouquetByCustomerBouquetId=" + customerBouquetByCustomerBouquetId + '}';
    }*/

    @Override
    public String toString() {
        return "FlowerCustomerBouquet{" + "id=" + id + ", flowerId=" + flowerId + ", customerBouquetId=" + customerBouquetId + ", quantity=" + quantity + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlowerCustomerBouquet that = (FlowerCustomerBouquet) o;

        if (quantity != that.quantity) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (flowerId != null ? !flowerId.equals(that.flowerId) : that.flowerId != null) return false;
        if (customerBouquetId != null ? !customerBouquetId.equals(that.customerBouquetId) : that.customerBouquetId != null)
            return false;
        if (flowerByFlowerId != null ? !flowerByFlowerId.equals(that.flowerByFlowerId) : that.flowerByFlowerId != null)
            return false;
        return customerBouquetByCustomerBouquetId != null ? customerBouquetByCustomerBouquetId.equals(that.customerBouquetByCustomerBouquetId) : that.customerBouquetByCustomerBouquetId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (flowerId != null ? flowerId.hashCode() : 0);
        result = 31 * result + (customerBouquetId != null ? customerBouquetId.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (flowerByFlowerId != null ? flowerByFlowerId.hashCode() : 0);
        result = 31 * result + (customerBouquetByCustomerBouquetId != null ? customerBouquetByCustomerBouquetId.hashCode() : 0);
        return result;
    }

    public Flower getFlowerByFlowerId() {
        return flowerByFlowerId;
    }

    public void setFlowerByFlowerId(Flower flowerByFlowerId) {
        this.flowerByFlowerId = flowerByFlowerId;
    }

    public CustomerBouquet getCustomerBouquetByCustomerBouquetId() {
        return customerBouquetByCustomerBouquetId;
    }

    public void setCustomerBouquetByCustomerBouquetId(CustomerBouquet customerBouquetByCustomerBouquetId) {
        this.customerBouquetByCustomerBouquetId = customerBouquetByCustomerBouquetId;
    }
}
