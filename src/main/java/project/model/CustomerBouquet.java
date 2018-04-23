package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "customer_bouquet")
public class CustomerBouquet {
    private Integer id;
    private Integer packId;
    private Pack packByPackId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pack_id", nullable = true)
    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerBouquet that = (CustomerBouquet) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (packId != null ? !packId.equals(that.packId) : that.packId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (packId != null ? packId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "pack_id", referencedColumnName = "id")
    public Pack getPackByPackId() {
        return packByPackId;
    }

    public void setPackByPackId(Pack packByPackId) {
        this.packByPackId = packByPackId;
    }
}
