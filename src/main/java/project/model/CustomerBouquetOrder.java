package project.model;

import javax.persistence.*;

@Entity
@Table(name = "customer_bouquet_order", schema = "flowers", catalog = "")
public class CustomerBouquetOrder {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "customer_bouquet_id", nullable = true, insertable = false, updatable = false)
    private Integer customerBouquetId;

    @Basic
    @Column(name = "order_id", nullable = true, insertable = false, updatable = false)
    private Integer orderId;

    @Basic
    @Column(name = "quantity", nullable = true)
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "customer_bouquet_id", referencedColumnName = "id")
    private CustomerBouquet customerBouquetByCustomerBouquetId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order orderByOrderId;

    public CustomerBouquetOrder() {}

    public CustomerBouquetOrder(Integer customerBouquetId, Integer orderId, int quantity) {
        this.customerBouquetId = customerBouquetId;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public CustomerBouquetOrder(Integer id, Integer customerBouquetId, Integer orderId, int quantity) {
        this.id = id;
        this.customerBouquetId = customerBouquetId;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public CustomerBouquetOrder(Integer customerBouquetId, Integer orderId, int quantity,
                                CustomerBouquet customerBouquetByCustomerBouquetId, Order orderByOrderId) {
        this.customerBouquetId = customerBouquetId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.customerBouquetByCustomerBouquetId = customerBouquetByCustomerBouquetId;
        this.orderByOrderId = orderByOrderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /*@Override
    public String toString() {
        return "CustomerBouquetOrder{" + "id=" + id + ", customerBouquetId=" + customerBouquetId + ", orderId=" + orderId + ", quantity=" + quantity + ", customerBouquetByCustomerBouquetId=" + customerBouquetByCustomerBouquetId + ", orderByOrderId=" + orderByOrderId + '}';
    }*/

    @Override
    public String toString() {
        return "CustomerBouquetOrder{" + "id=" + id + ", customerBouquetId=" + customerBouquetId + ", orderId=" + orderId + ", quantity=" + quantity + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerBouquetOrder that = (CustomerBouquetOrder) o;

        if (quantity != that.quantity) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (customerBouquetId != null ? !customerBouquetId.equals(that.customerBouquetId) : that.customerBouquetId != null)
            return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (customerBouquetByCustomerBouquetId != null ? !customerBouquetByCustomerBouquetId.equals(that.customerBouquetByCustomerBouquetId) : that.customerBouquetByCustomerBouquetId != null)
            return false;
        return orderByOrderId != null ? orderByOrderId.equals(that.orderByOrderId) : that.orderByOrderId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customerBouquetId != null ? customerBouquetId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (customerBouquetByCustomerBouquetId != null ? customerBouquetByCustomerBouquetId.hashCode() : 0);
        result = 31 * result + (orderByOrderId != null ? orderByOrderId.hashCode() : 0);
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
