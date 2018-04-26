package project.model;

import javax.persistence.*;

@Entity
@Table(name = "bouquet_order", schema = "flowers", catalog = "")
public class BouquetOrder {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "bouquet_id", nullable = true, insertable = false, updatable = false)
    private Integer bouquetId;

    @Basic
    @Column(name = "order_id", nullable = true, insertable = false, updatable = false)
    private Integer orderId;

    @Basic
    @Column(name = "quantity", nullable = true)
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "bouquet_id", referencedColumnName = "id")
    private Bouquet bouquetByBouquetId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order orderByOrderId;

    public BouquetOrder() {}

    public BouquetOrder(Integer bouquetId, Integer orderId, int quantity) {
        this.bouquetId = bouquetId;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public BouquetOrder(Integer id, Integer bouquetId, Integer orderId, int quantity) {
        this.id = id;
        this.bouquetId = bouquetId;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public BouquetOrder(Integer id, Integer bouquetId, Integer orderId, int quantity,
                        Bouquet bouquetByBouquetId, Order orderByOrderId) {
        this.id = id;
        this.bouquetId = bouquetId;
        this.orderId = orderId;
        this.bouquetByBouquetId = bouquetByBouquetId;
        this.orderByOrderId = orderByOrderId;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBouquetId() {
        return bouquetId;
    }

    public void setBouquetId(Integer bouquetId) {
        this.bouquetId = bouquetId;
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
        return "BouquetOrder{" + "id=" + id + ", bouquetId=" + bouquetId + ", orderId=" + orderId + ", quantity=" + quantity + ", bouquetByBouquetId=" + bouquetByBouquetId + ", orderByOrderId=" + orderByOrderId + '}';
    }*/

    @Override
    public String toString() {
        return "BouquetOrder{" + "id=" + id + ", bouquetId=" + bouquetId + ", orderId=" + orderId + ", quantity=" + quantity + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BouquetOrder that = (BouquetOrder) o;

        if (quantity != that.quantity) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (bouquetId != null ? !bouquetId.equals(that.bouquetId) : that.bouquetId != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (bouquetByBouquetId != null ? !bouquetByBouquetId.equals(that.bouquetByBouquetId) : that.bouquetByBouquetId != null)
            return false;
        return orderByOrderId != null ? orderByOrderId.equals(that.orderByOrderId) : that.orderByOrderId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bouquetId != null ? bouquetId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (bouquetByBouquetId != null ? bouquetByBouquetId.hashCode() : 0);
        result = 31 * result + (orderByOrderId != null ? orderByOrderId.hashCode() : 0);
        return result;
    }

    public Bouquet getBouquetByBouquetId() {
        return bouquetByBouquetId;
    }

    public void setBouquetByBouquetId(Bouquet bouquetByBouquetId) {
        this.bouquetByBouquetId = bouquetByBouquetId;
    }

    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
