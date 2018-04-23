package project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Order {
    private Integer id;
    private Integer userId;
    private Integer senderId;
    private Integer recipientId;
    private Integer addressId;
    private Integer payment;
    private String date;
    private String postcard;
    private String additionalInf;
    private Double cost;
    private User userByUserId;
    private Sender senderBySenderId;
    private Recipient recipientByRecipientId;
    private Address addressByAddressId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "sender_id", nullable = true)
    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    @Basic
    @Column(name = "recipient_id", nullable = true)
    public Integer getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }

    @Basic
    @Column(name = "address_id", nullable = true)
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "payment", nullable = false)
    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "date", nullable = false, length = 50)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "postcard", nullable = true, length = 80)
    public String getPostcard() {
        return postcard;
    }

    public void setPostcard(String postcard) {
        this.postcard = postcard;
    }

    @Basic
    @Column(name = "additional_inf", nullable = true, length = 150)
    public String getAdditionalInf() {
        return additionalInf;
    }

    public void setAdditionalInf(String additionalInf) {
        this.additionalInf = additionalInf;
    }

    @Basic
    @Column(name = "cost", nullable = false, precision = 0)
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (userId != null ? !userId.equals(order.userId) : order.userId != null) return false;
        if (senderId != null ? !senderId.equals(order.senderId) : order.senderId != null) return false;
        if (recipientId != null ? !recipientId.equals(order.recipientId) : order.recipientId != null) return false;
        if (addressId != null ? !addressId.equals(order.addressId) : order.addressId != null) return false;
        if (payment != null ? !payment.equals(order.payment) : order.payment != null) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        if (postcard != null ? !postcard.equals(order.postcard) : order.postcard != null) return false;
        if (additionalInf != null ? !additionalInf.equals(order.additionalInf) : order.additionalInf != null)
            return false;
        if (cost != null ? !cost.equals(order.cost) : order.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (recipientId != null ? recipientId.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (postcard != null ? postcard.hashCode() : 0);
        result = 31 * result + (additionalInf != null ? additionalInf.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    public Sender getSenderBySenderId() {
        return senderBySenderId;
    }

    public void setSenderBySenderId(Sender senderBySenderId) {
        this.senderBySenderId = senderBySenderId;
    }

    @ManyToOne
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    public Recipient getRecipientByRecipientId() {
        return recipientByRecipientId;
    }

    public void setRecipientByRecipientId(Recipient recipientByRecipientId) {
        this.recipientByRecipientId = recipientByRecipientId;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }
}
