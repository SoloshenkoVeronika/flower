package project.model;

import javax.persistence.*;

@Entity
@Table(name = "flower_order", schema = "flowers", catalog = "")
public class FlowerOrder {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "flower_id", nullable = true, insertable = false, updatable = false)
    private Integer flowerId;

    @Basic
    @Column(name = "order_id", nullable = true, insertable = false, updatable = false)
    private Integer orderId;

    @Basic
    @Column(name = "quantity", nullable = true)
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "flower_id", referencedColumnName = "id")
    private Flower flowerByFlowerId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order orderByOrderId;

    public FlowerOrder() {}

    public FlowerOrder(Integer flowerId, Integer orderId, int quantity) {
        this.flowerId = flowerId;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public FlowerOrder(Integer id, Integer flowerId, Integer orderId, int quantity) {
        this.id = id;
        this.flowerId = flowerId;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public FlowerOrder(Integer id, Integer flowerId, Integer orderId, int quantity,
                       Flower flowerByFlowerId, Order orderByOrderId) {
        this.id = id;
        this.flowerId = flowerId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.flowerByFlowerId = flowerByFlowerId;
        this.orderByOrderId = orderByOrderId;
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
        return "FlowerOrder{" + "id=" + id + ", flowerId=" + flowerId + ", orderId=" + orderId + ", quantity=" + quantity + ", flowerByFlowerId=" + flowerByFlowerId + ", orderByOrderId=" + orderByOrderId + '}';
    }*/

    @Override
    public String toString() {
        return "FlowerOrder{" + "id=" + id + ", flowerId=" + flowerId + ", orderId=" + orderId + ", quantity=" + quantity + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlowerOrder that = (FlowerOrder) o;

        if (quantity != that.quantity) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (flowerId != null ? !flowerId.equals(that.flowerId) : that.flowerId != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (flowerByFlowerId != null ? !flowerByFlowerId.equals(that.flowerByFlowerId) : that.flowerByFlowerId != null)
            return false;
        return orderByOrderId != null ? orderByOrderId.equals(that.orderByOrderId) : that.orderByOrderId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (flowerId != null ? flowerId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (flowerByFlowerId != null ? flowerByFlowerId.hashCode() : 0);
        result = 31 * result + (orderByOrderId != null ? orderByOrderId.hashCode() : 0);
        return result;
    }

    public Flower getFlowerByFlowerId() {
        return flowerByFlowerId;
    }

    public void setFlowerByFlowerId(Flower flowerByFlowerId) {
        this.flowerByFlowerId = flowerByFlowerId;
    }

    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
