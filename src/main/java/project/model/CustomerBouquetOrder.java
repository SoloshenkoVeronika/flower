package project.model;

import javax.persistence.*;

@Entity
@Table(name = "customer_bouquet_order", schema = "flowers", catalog = "")
public class CustomerBouquetOrder {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "customer_bouquet_id", nullable = true, insertable = false, updatable = false)
    private Integer customerBouquetId;

    @Basic
    @Column(name = "order_id", nullable = true, insertable = false, updatable = false)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "customer_bouquet_id", referencedColumnName = "id")
    private CustomerBouquet customerBouquetByCustomerBouquetId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order orderByOrderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCustomerBouquetId() {
        return customerBouquetId;
    }

    public void setCustomerBouquetId(Integer customerBouquetId) {
        this.customerBouquetId = customerBouquetId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerBouquetOrder that = (CustomerBouquetOrder) o;

        if (customerBouquetId != null ? !customerBouquetId.equals(that.customerBouquetId) : that.customerBouquetId != null)
            return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerBouquetId != null ? customerBouquetId.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }

    public CustomerBouquet getCustomerBouquetByCustomerBouquetId() {
        return customerBouquetByCustomerBouquetId;
    }

    public void setCustomerBouquetByCustomerBouquetId(CustomerBouquet customerBouquetByCustomerBouquetId) {
        this.customerBouquetByCustomerBouquetId = customerBouquetByCustomerBouquetId;
    }

    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
