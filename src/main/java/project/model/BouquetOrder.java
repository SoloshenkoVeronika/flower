package project.model;

import javax.persistence.*;

@Entity
@Table(name = "bouquet_order", schema = "flowers", catalog = "")
public class BouquetOrder {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "bouquet_id", nullable = true, insertable = false, updatable = false)
    private Integer bouquetId;

    @Basic
    @Column(name = "order_id", nullable = true, insertable = false, updatable = false)
    private Integer orderId;


    @ManyToOne
    @JoinColumn(name = "bouquet_id", referencedColumnName = "id")
    private Bouquet bouquetByBouquetId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order orderByOrderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BouquetOrder that = (BouquetOrder) o;

        if (bouquetId != null ? !bouquetId.equals(that.bouquetId) : that.bouquetId != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bouquetId != null ? bouquetId.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
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
