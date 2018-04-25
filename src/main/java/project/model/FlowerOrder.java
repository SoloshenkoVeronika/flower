package project.model;

import javax.persistence.*;

@Entity
@Table(name = "flower_order", schema = "flowers", catalog = "")
public class FlowerOrder {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "flower_id", nullable = true, insertable = false, updatable = false)
    private Integer flowerId;

    @Basic
    @Column(name = "order_id", nullable = true, insertable = false, updatable = false)
    private Integer orderId;


    @ManyToOne
    @JoinColumn(name = "flower_id", referencedColumnName = "id")
    private Flower flowerByFlowerId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order orderByOrderId;

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

        FlowerOrder that = (FlowerOrder) o;

        if (flowerId != null ? !flowerId.equals(that.flowerId) : that.flowerId != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flowerId != null ? flowerId.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
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
