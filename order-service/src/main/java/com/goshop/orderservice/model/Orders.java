package com.goshop.orderservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private double totalAmount;
    private long addressId;
    private long paymentId;
    private Date creationDate;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value ={"orders"})
    private Set<OrderDetails> orderDetails;

    public Orders(){
        orderDetails = new HashSet<>();

    }

    public Orders(long userId, double totalAmount, long addressId, long paymentId, Set<OrderDetails> orderDetails, Date creationDate) {
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.addressId = addressId;
        this.paymentId = paymentId;
        this.orderDetails = orderDetails;
        this.creationDate=creationDate;
    }


    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
        for (OrderDetails orderDetail : orderDetails) {
            orderDetail.setOrders(this);
        }
    }

    public Orders addOrderDetail(OrderDetails orderDetails){
        this.orderDetails.add(orderDetails);
        return this;
    }
}
