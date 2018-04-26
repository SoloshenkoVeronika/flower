package project.model;

import javax.persistence.*;

@Entity
@Table(name = "composition_order", schema = "flowers", catalog = "")
public class CompositionOrder {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "composition_id", nullable = true, insertable = false, updatable = false)
    private Integer compositionId;

    @Basic
    @Column(name = "order_id", nullable = true, insertable = false, updatable = false)
    private Integer orderId;

    @Basic
    @Column(name = "quantity", nullable = true)
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "composition_id", referencedColumnName = "id")
    private Composition compositionByCompositionId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order orderByOrderId;

    public CompositionOrder() {}

    public CompositionOrder(Integer compositionId, Integer orderId, int quantity) {
        this.compositionId = compositionId;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public CompositionOrder(Integer id, Integer compositionId, Integer orderId, int quantity) {
        this.id = id;
        this.compositionId = compositionId;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public CompositionOrder(Integer id, Integer compositionId, Integer orderId, int quantity,
                            Composition compositionByCompositionId, Order orderByOrderId) {
        this.id = id;
        this.compositionId = compositionId;
        this.orderId = orderId;
        this.compositionByCompositionId = compositionByCompositionId;
        this.orderByOrderId = orderByOrderId;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /*@Override
    public String toString() {
        return "CompositionOrder{" + "id=" + id + ", compositionId=" + compositionId + ", orderId=" + orderId + ", quantity=" + quantity + ", compositionByCompositionId=" + compositionByCompositionId + ", orderByOrderId=" + orderByOrderId + '}';
    }*/

    @Override
    public String toString() {
        return "CompositionOrder{" + "id=" + id + ", compositionId=" + compositionId + ", orderId=" + orderId + ", quantity=" + quantity + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompositionOrder that = (CompositionOrder) o;

        if (quantity != that.quantity) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (compositionId != null ? !compositionId.equals(that.compositionId) : that.compositionId != null)
            return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (compositionByCompositionId != null ? !compositionByCompositionId.equals(that.compositionByCompositionId) : that.compositionByCompositionId != null)
            return false;
        return orderByOrderId != null ? orderByOrderId.equals(that.orderByOrderId) : that.orderByOrderId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (compositionId != null ? compositionId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (compositionByCompositionId != null ? compositionByCompositionId.hashCode() : 0);
        result = 31 * result + (orderByOrderId != null ? orderByOrderId.hashCode() : 0);
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
