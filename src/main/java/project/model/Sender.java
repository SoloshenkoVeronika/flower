package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Sender {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "first_name", nullable = true, length = 50)
    private String firstName;

    @Basic
    @Column(name = "second_name", nullable = true, length = 50)
    private String secondName;

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    private String phone;

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    private String email;


    @OneToMany(mappedBy = "senderBySenderId")
    private Collection<Order> ordersById;

    public Sender() {}

    public Sender(String firstName, String secondName, String phone, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.email = email;
    }

    public Sender(Integer id, String firstName, String secondName, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.email = email;
    }

    public Sender(Integer id, String firstName, String secondName, String phone,
                  String email, Collection<Order> ordersById) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*@Override
    public String toString() {
        return "Sender{" + "id=" + id + ", firstName='" + firstName + '\'' + ", secondName='" + secondName + '\'' + ", phone='" + phone + '\'' + ", email='" + email + '\'' + ", ordersById=" + ordersById + '}';
    }*/

    @Override
    public String toString() {
        return "Sender{" + "id=" + id + ", firstName='" + firstName + '\'' + ", secondName='" + secondName + '\'' + ", phone='" + phone + '\'' + ", email='" + email + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sender sender = (Sender) o;

        if (id != null ? !id.equals(sender.id) : sender.id != null) return false;
        if (firstName != null ? !firstName.equals(sender.firstName) : sender.firstName != null) return false;
        if (secondName != null ? !secondName.equals(sender.secondName) : sender.secondName != null) return false;
        if (phone != null ? !phone.equals(sender.phone) : sender.phone != null) return false;
        if (email != null ? !email.equals(sender.email) : sender.email != null) return false;
        return ordersById != null ? ordersById.equals(sender.ordersById) : sender.ordersById == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
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
