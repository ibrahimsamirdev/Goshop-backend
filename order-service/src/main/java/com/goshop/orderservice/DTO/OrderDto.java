package com.goshop.orderservice.DTO;

import java.time.LocalDate;
import java.util.Set;

public class OrderDto {
    private long id;
    private long userId;
    private long paymentId;
    private long addressId;
    private double totalAmount;
    private Set<OrderDetailsDto> orderDetails;
    private LocalDate creationDate;

    public OrderDto() {
    }


    public OrderDto(long userId, long paymentId, long addressId, double totalAmount, LocalDate creationDate) {
        this.userId = userId;
        this.paymentId = paymentId;
        this.addressId = addressId;
        this.totalAmount = totalAmount;
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Set<OrderDetailsDto> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetailsDto> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Set<OrderDetailsDto> getOrderDetails(OrderDto orderDto) {
        return orderDto.getOrderDetails();
    }
}
