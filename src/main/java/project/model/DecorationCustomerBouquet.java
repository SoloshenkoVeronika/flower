package project.model;

import javax.persistence.*;

@Entity
@Table(name = "decoration_customer_bouquet", schema = "flowers", catalog = "")
public class DecorationCustomerBouquet {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "decoration_id", nullable = true, insertable = false, updatable = false)
    private Integer decorationId;

    @Basic
    @Column(name = "customer_bouquet_id", nullable = true, insertable = false, updatable = false)
    private Integer customerBouquetId;

    @Basic
    @Column(name = "quantity", nullable = true)
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "decoration_id", referencedColumnName = "id")
    private Decoration decorationByDecorationId;

    @ManyToOne
    @JoinColumn(name = "customer_bouquet_id", referencedColumnName = "id")
    private CustomerBouquet customerBouquetByCustomerBouquetId;

    public DecorationCustomerBouquet() {}

    public DecorationCustomerBouquet(Integer decorationId, Integer customerBouquetId, int quantity) {
        this.decorationId = decorationId;
        this.customerBouquetId = customerBouquetId;
        this.quantity = quantity;
    }

    public DecorationCustomerBouquet(Integer id, Integer decorationId, Integer customerBouquetId, int quantity) {
        this.id = id;
        this.decorationId = decorationId;
        this.customerBouquetId = customerBouquetId;
        this.quantity = quantity;
    }

    public DecorationCustomerBouquet(Integer id, Integer decorationId, Integer customerBouquetId, int quantity,
                                     Decoration decorationByDecorationId, CustomerBouquet customerBouquetByCustomerBouquetId) {
        this.id = id;
        this.decorationId = decorationId;
        this.customerBouquetId = customerBouquetId;
        this.quantity = quantity;
        this.decorationByDecorationId = decorationByDecorationId;
        this.customerBouquetByCustomerBouquetId = customerBouquetByCustomerBouquetId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDecorationId() {
        return decorationId;
    }

    public void setDecorationId(Integer decorationId) {
        this.decorationId = decorationId;
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
        return "DecorationCustomerBouquet{" + "id=" + id + ", decorationId=" + decorationId + ", customerBouquetId=" + customerBouquetId + ", quantity=" + quantity + ", decorationByDecorationId=" + decorationByDecorationId + ", customerBouquetByCustomerBouquetId=" + customerBouquetByCustomerBouquetId + '}';
    }*/

    @Override
    public String toString() {
        return "DecorationCustomerBouquet{" + "id=" + id + ", decorationId=" + decorationId + ", customerBouquetId=" + customerBouquetId + ", quantity=" + quantity + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DecorationCustomerBouquet that = (DecorationCustomerBouquet) o;

        if (quantity != that.quantity) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (decorationId != null ? !decorationId.equals(that.decorationId) : that.decorationId != null) return false;
        if (customerBouquetId != null ? !customerBouquetId.equals(that.customerBouquetId) : that.customerBouquetId != null)
            return false;
        if (decorationByDecorationId != null ? !decorationByDecorationId.equals(that.decorationByDecorationId) : that.decorationByDecorationId != null)
            return false;
        return customerBouquetByCustomerBouquetId != null ? customerBouquetByCustomerBouquetId.equals(that.customerBouquetByCustomerBouquetId) : that.customerBouquetByCustomerBouquetId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (decorationId != null ? decorationId.hashCode() : 0);
        result = 31 * result + (customerBouquetId != null ? customerBouquetId.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (decorationByDecorationId != null ? decorationByDecorationId.hashCode() : 0);
        result = 31 * result + (customerBouquetByCustomerBouquetId != null ? customerBouquetByCustomerBouquetId.hashCode() : 0);
        return result;
    }

    public Decoration getDecorationByDecorationId() {
        return decorationByDecorationId;
    }

    public void setDecorationByDecorationId(Decoration decorationByDecorationId) {
        this.decorationByDecorationId = decorationByDecorationId;
    }

    public CustomerBouquet getCustomerBouquetByCustomerBouquetId() {
        return customerBouquetByCustomerBouquetId;
    }

    public void setCustomerBouquetByCustomerBouquetId(CustomerBouquet customerBouquetByCustomerBouquetId) {
        this.customerBouquetByCustomerBouquetId = customerBouquetByCustomerBouquetId;
    }
}
