package project.model;

import javax.persistence.*;

@Entity
@Table(name = "flower_customer_bouquet", schema = "flowers", catalog = "")
public class FlowerCustomerBouquet {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "flower_id", nullable = true, insertable = false, updatable = false)
    private Integer flowerId;

    @Basic
    @Column(name = "customer_bouquet_id", nullable = true, insertable = false, updatable = false)
    private Integer customerBouquetId;


    @ManyToOne
    @JoinColumn(name = "flower_id", referencedColumnName = "id")
    private Flower flowerByFlowerId;

    @ManyToOne
    @JoinColumn(name = "customer_bouquet_id", referencedColumnName = "id")
    private CustomerBouquet customerBouquetByCustomerBouquetId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlowerCustomerBouquet that = (FlowerCustomerBouquet) o;

        if (flowerId != null ? !flowerId.equals(that.flowerId) : that.flowerId != null) return false;
        if (customerBouquetId != null ? !customerBouquetId.equals(that.customerBouquetId) : that.customerBouquetId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flowerId != null ? flowerId.hashCode() : 0;
        result = 31 * result + (customerBouquetId != null ? customerBouquetId.hashCode() : 0);
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
