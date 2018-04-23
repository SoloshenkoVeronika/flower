package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Sender {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Collection<Order> ordersById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 256)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 256)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 256)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sender sender = (Sender) o;

        if (id != null ? !id.equals(sender.id) : sender.id != null) return false;
        if (name != null ? !name.equals(sender.name) : sender.name != null) return false;
        if (surname != null ? !surname.equals(sender.surname) : sender.surname != null) return false;
        if (phone != null ? !phone.equals(sender.phone) : sender.phone != null) return false;
        if (email != null ? !email.equals(sender.email) : sender.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "senderBySenderId")
    public Collection<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Order> ordersById) {
        this.ordersById = ordersById;
    }
}
