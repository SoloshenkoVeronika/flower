package project.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "order_", schema = "flowers", catalog = "")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "user_id", nullable = true)
    private Integer userId;

    @Basic
    @Column(name = "sender_id", nullable = true)
    private Integer senderId;

    @Basic
    @Column(name = "recipient_id", nullable = true)
    private Integer recipientId;

    @Basic
    @Column(name = "address_id", nullable = true)
    private Integer addressId;

    @Basic
    @Column(name = "date", nullable = false)
    private Date date;

    @Basic
    @Column(name = "postcard", nullable = true, length = 80)
    private String postcard;

    @Basic
    @Column(name = "additional_inf", nullable = true, length = 180)
    private String additionalInf;

    @Basic
    @Column(name = "payment", nullable = false, length = 30)
    private String payment;

    @Basic
    @Column(name = "cost", nullable = false, precision = 0)
    private double cost;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User userByUserId;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Sender senderBySenderId;

    @ManyToOne
    @JoinColumn(name = "recipient_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Recipient recipientByRecipientId;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Address addressByAddressId;

    @OneToMany(mappedBy = "orderByOrderId", fetch = FetchType.EAGER)
    private Collection<BouquetOrder> bouquetOrdersById;

    @OneToMany(mappedBy = "orderByOrderId", fetch = FetchType.EAGER)
    private Collection<CompositionOrder> compositionOrdersById;

    @OneToMany(mappedBy = "orderByOrderId", fetch = FetchType.EAGER)
    private Collection<CustomerBouquetOrder> customerBouquetOrdersById;

    @OneToMany(mappedBy = "orderByOrderId", fetch = FetchType.EAGER)
    private Collection<FlowerOrder> flowerOrdersById;

    public Order() {}

    public Order(Integer userId, Integer senderId, Integer recipientId, Integer addressId,
                 Date date, String postcard, String additionalInf, String payment, double cost) {
        this.userId = userId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.addressId = addressId;
        this.date = date;
        this.postcard = postcard;
        this.additionalInf = additionalInf;
        this.payment = payment;
        this.cost = cost;
    }

    public Order(Integer id, Integer userId, Integer senderId, Integer recipientId, Integer addressId,
                 Date date, String postcard, String additionalInf, String payment, double cost) {
        this.id = id;
        this.userId = userId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.addressId = addressId;
        this.date = date;
        this.postcard = postcard;
        this.additionalInf = additionalInf;
        this.payment = payment;
        this.cost = cost;
    }

    public Order(Integer id, Integer userId, Integer senderId, Integer recipientId, Integer addressId,
                 Date date, String postcard, String additionalInf, String payment, double cost, User userByUserId,
                 Sender senderBySenderId, Recipient recipientByRecipientId, Address addressByAddressId) {
        this.id = id;
        this.userId = userId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.addressId = addressId;
        this.date = date;
        this.postcard = postcard;
        this.additionalInf = additionalInf;
        this.payment = payment;
        this.cost = cost;
        this.userByUserId = userByUserId;
        this.senderBySenderId = senderBySenderId;
        this.recipientByRecipientId = recipientByRecipientId;
        this.addressByAddressId = addressByAddressId;
    }

    public Order(Integer id, Integer userId, Integer senderId, Integer recipientId, Integer addressId,
                 Date date, String postcard, String additionalInf, String payment, double cost,
                 User userByUserId, Sender senderBySenderId, Recipient recipientByRecipientId,
                 Address addressByAddressId, Collection<BouquetOrder> bouquetOrdersById,
                 Collection<CompositionOrder> compositionOrdersById,
                 Collection<CustomerBouquetOrder> customerBouquetOrdersById, Collection<FlowerOrder> flowerOrdersById) {
        this.id = id;
        this.userId = userId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.addressId = addressId;
        this.date = date;
        this.postcard = postcard;
        this.additionalInf = additionalInf;
        this.payment = payment;
        this.cost = cost;
        this.userByUserId = userByUserId;
        this.senderBySenderId = senderBySenderId;
        this.recipientByRecipientId = recipientByRecipientId;
        this.addressByAddressId = addressByAddressId;
        this.bouquetOrdersById = bouquetOrdersById;
        this.compositionOrdersById = compositionOrdersById;
        this.customerBouquetOrdersById = customerBouquetOrdersById;
        this.flowerOrdersById = flowerOrdersById;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPostcard() {
        return postcard;
    }

    public void setPostcard(String postcard) {
        this.postcard = postcard;
    }

    public String getAdditionalInf() {
        return additionalInf;
    }

    public void setAdditionalInf(String additionalInf) {
        this.additionalInf = additionalInf;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    /*@Override
    public String toString() {
        return "Order{" + "id=" + id + ", userId=" + userId + ", senderId=" + senderId + ", recipientId=" + recipientId + ", addressId=" + addressId + ", date=" + date + ", postcard='" + postcard + '\'' + ", additionalInf='" + additionalInf + '\'' + ", payment=" + payment + ", cost=" + cost + ", userByUserId=" + userByUserId + ", senderBySenderId=" + senderBySenderId + ", recipientByRecipientId=" + recipientByRecipientId + ", addressByAddressId=" + addressByAddressId + ", bouquetOrdersById=" + bouquetOrdersById + ", compositionOrdersById=" + compositionOrdersById + ", customerBouquetOrdersById=" + customerBouquetOrdersById + ", flowerOrdersById=" + flowerOrdersById + '}';
    }*/

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", userId=" + userId + ", senderId=" + senderId + ", recipientId=" + recipientId + ", addressId=" + addressId + ", date=" + date + ", postcard='" + postcard + '\'' + ", additionalInf='" + additionalInf + '\'' + ", payment=" + payment + ", cost=" + cost + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (Double.compare(order.cost, cost) != 0) return false;
        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (userId != null ? !userId.equals(order.userId) : order.userId != null) return false;
        if (senderId != null ? !senderId.equals(order.senderId) : order.senderId != null) return false;
        if (recipientId != null ? !recipientId.equals(order.recipientId) : order.recipientId != null) return false;
        if (addressId != null ? !addressId.equals(order.addressId) : order.addressId != null) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        if (postcard != null ? !postcard.equals(order.postcard) : order.postcard != null) return false;
        if (additionalInf != null ? !additionalInf.equals(order.additionalInf) : order.additionalInf != null)
            return false;
        if (payment != null ? !payment.equals(order.payment) : order.payment != null) return false;
        if (userByUserId != null ? !userByUserId.equals(order.userByUserId) : order.userByUserId != null) return false;
        if (senderBySenderId != null ? !senderBySenderId.equals(order.senderBySenderId) : order.senderBySenderId != null)
            return false;
        if (recipientByRecipientId != null ? !recipientByRecipientId.equals(order.recipientByRecipientId) : order.recipientByRecipientId != null)
            return false;
        if (addressByAddressId != null ? !addressByAddressId.equals(order.addressByAddressId) : order.addressByAddressId != null)
            return false;
        if (bouquetOrdersById != null ? !bouquetOrdersById.equals(order.bouquetOrdersById) : order.bouquetOrdersById != null)
            return false;
        if (compositionOrdersById != null ? !compositionOrdersById.equals(order.compositionOrdersById) : order.compositionOrdersById != null)
            return false;
        if (customerBouquetOrdersById != null ? !customerBouquetOrdersById.equals(order.customerBouquetOrdersById) : order.customerBouquetOrdersById != null)
            return false;
        return flowerOrdersById != null ? flowerOrdersById.equals(order.flowerOrdersById) : order.flowerOrdersById == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (recipientId != null ? recipientId.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (postcard != null ? postcard.hashCode() : 0);
        result = 31 * result + (additionalInf != null ? additionalInf.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (userByUserId != null ? userByUserId.hashCode() : 0);
        result = 31 * result + (senderBySenderId != null ? senderBySenderId.hashCode() : 0);
        result = 31 * result + (recipientByRecipientId != null ? recipientByRecipientId.hashCode() : 0);
        result = 31 * result + (addressByAddressId != null ? addressByAddressId.hashCode() : 0);
        result = 31 * result + (bouquetOrdersById != null ? bouquetOrdersById.hashCode() : 0);
        result = 31 * result + (compositionOrdersById != null ? compositionOrdersById.hashCode() : 0);
        result = 31 * result + (customerBouquetOrdersById != null ? customerBouquetOrdersById.hashCode() : 0);
        result = 31 * result + (flowerOrdersById != null ? flowerOrdersById.hashCode() : 0);
        return result;
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Sender getSenderBySenderId() {
        return senderBySenderId;
    }

    public void setSenderBySenderId(Sender senderBySenderId) {
        this.senderBySenderId = senderBySenderId;
    }

    public Recipient getRecipientByRecipientId() {
        return recipientByRecipientId;
    }

    public void setRecipientByRecipientId(Recipient recipientByRecipientId) {
        this.recipientByRecipientId = recipientByRecipientId;
    }

    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    public Collection<BouquetOrder> getBouquetOrdersById() {
        return bouquetOrdersById;
    }

    public void setBouquetOrdersById(Collection<BouquetOrder> bouquetOrdersById) {
        this.bouquetOrdersById = bouquetOrdersById;
    }

    public Collection<CompositionOrder> getCompositionOrdersById() {
        return compositionOrdersById;
    }

    public void setCompositionOrdersById(Collection<CompositionOrder> compositionOrdersById) {
        this.compositionOrdersById = compositionOrdersById;
    }

    public Collection<CustomerBouquetOrder> getCustomerBouquetOrdersById() {
        return customerBouquetOrdersById;
    }

    public void setCustomerBouquetOrdersById(Collection<CustomerBouquetOrder> customerBouquetOrdersById) {
        this.customerBouquetOrdersById = customerBouquetOrdersById;
    }

    public Collection<FlowerOrder> getFlowerOrdersById() {
        return flowerOrdersById;
    }

    public void setFlowerOrdersById(Collection<FlowerOrder> flowerOrdersById) {
        this.flowerOrdersById = flowerOrdersById;
    }
}
