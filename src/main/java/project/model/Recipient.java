package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Recipient {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Basic
    @Column(name = "second_name", nullable = false, length = 50)
    private String secondName;

    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;


    @OneToMany(mappedBy = "recipientByRecipientId")
    private Collection<Order> ordersById;

    public Recipient() {}

    public Recipient(String firstName, String secondName, String phone) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
    }

    public Recipient(Integer id, String firstName, String secondName, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
    }

    public Recipient(Integer id, String firstName, String secondName, String phone, Collection<Order> ordersById) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.ordersById = ordersById;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /*@Override
    public String toString() {
        return "Recipient{" + "id=" + id + ", firstName='" + firstName + '\'' + ", secondName='" + secondName + '\'' + ", phone='" + phone + '\'' + ", ordersById=" + ordersById + '}';
    }*/

    @Override
    public String toString() {
        return "Recipient{" + "id=" + id + ", firstName='" + firstName + '\'' + ", secondName='" + secondName + '\'' + ", phone='" + phone + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipient recipient = (Recipient) o;

        if (id != null ? !id.equals(recipient.id) : recipient.id != null) return false;
        if (firstName != null ? !firstName.equals(recipient.firstName) : recipient.firstName != null) return false;
        if (secondName != null ? !secondName.equals(recipient.secondName) : recipient.secondName != null) return false;
        if (phone != null ? !phone.equals(recipient.phone) : recipient.phone != null) return false;
        return ordersById != null ? ordersById.equals(recipient.ordersById) : recipient.ordersById == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (ordersById != null ? ordersById.hashCode() : 0);
        return result;
    }

    public Collection<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Order> ordersById) {
        this.ordersById = ordersById;
    }
}
