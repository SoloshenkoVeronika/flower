package project.model;

import javax.persistence.*;

@Entity
@Table(name = "decoration_customer_bouquet", schema = "flowers", catalog = "")
public class DecorationCustomerBouquet {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "decoration_id", nullable = true, insertable = false, updatable = false)
    private Integer decorationId;

    @Basic
    @Column(name = "customer_bouquet_id", nullable = true, insertable = false, updatable = false)
    private Integer customerBouquetId;


    @ManyToOne
    @JoinColumn(name = "decoration_id", referencedColumnName = "id")
    private Decoration decorationByDecorationId;

    @ManyToOne
    @JoinColumn(name = "customer_bouquet_id", referencedColumnName = "id")
    private CustomerBouquet customerBouquetByCustomerBouquetId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DecorationCustomerBouquet that = (DecorationCustomerBouquet) o;

        if (decorationId != null ? !decorationId.equals(that.decorationId) : that.decorationId != null) return false;
        if (customerBouquetId != null ? !customerBouquetId.equals(that.customerBouquetId) : that.customerBouquetId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = decorationId != null ? decorationId.hashCode() : 0;
        result = 31 * result + (customerBouquetId != null ? customerBouquetId.hashCode() : 0);
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
