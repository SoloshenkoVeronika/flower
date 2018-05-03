package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login", nullable = false, length = 50)
    private String login;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "status", nullable = true)
    private int status;


    @OneToMany(mappedBy = "userByUserId", fetch = FetchType.EAGER)
    private Collection<Order> ordersById;

    public User() {}

    public User(String login, String password, int status) {
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public User(Integer id, String login, String password, int status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public User(Integer id, String login, String password, int status, Collection<Order> ordersById) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
        this.ordersById = ordersById;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /*@Override
    public String toString() {
        return "User{" + "id=" + id + ", login='" + login + '\'' + ", password='" + password + '\'' + ", status=" + status + ", ordersById=" + ordersById + '}';
    }*/

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login='" + login + '\'' + ", password='" + password + '\'' + ", status=" + status + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (status != user.status) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return ordersById != null ? ordersById.equals(user.ordersById) : user.ordersById == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + status;
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
