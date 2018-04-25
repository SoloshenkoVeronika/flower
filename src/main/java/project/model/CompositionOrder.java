package project.model;

import javax.persistence.*;

@Entity
@Table(name = "composition_order", schema = "flowers", catalog = "")
public class CompositionOrder {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "composition_id", nullable = true, insertable = false, updatable = false)
    private Integer compositionId;

    @Basic
    @Column(name = "order_id", nullable = true, insertable = false, updatable = false)
    private Integer orderId;


    @ManyToOne
    @JoinColumn(name = "composition_id", referencedColumnName = "id")
    private Composition compositionByCompositionId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order orderByOrderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCompositionId() {
        return compositionId;
    }

    public void setCompositionId(Integer compositionId) {
        this.compositionId = compositionId;
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

        CompositionOrder that = (CompositionOrder) o;

        if (compositionId != null ? !compositionId.equals(that.compositionId) : that.compositionId != null)
            return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = compositionId != null ? compositionId.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }

    public Composition getCompositionByCompositionId() {
        return compositionByCompositionId;
    }

    public void setCompositionByCompositionId(Composition compositionByCompositionId) {
        this.compositionByCompositionId = compositionByCompositionId;
    }

    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
