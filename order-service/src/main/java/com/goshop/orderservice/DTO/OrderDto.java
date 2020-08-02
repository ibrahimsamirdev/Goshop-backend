package com.goshop.orderservice.DTO;

import java.util.Set;

public class OrderDto {
    private long userId;
    private long paymentId;
    private long addressId;
    private double totalAmount;
    private Set<ProductDto> ProductDtos;

    public OrderDto(){
    }

    public OrderDto(long userId, long paymentId, long addressId, double totalAmount, Set<ProductDto> ProductDtos) {
        this.userId = userId;
        this.paymentId = paymentId;
        this.addressId = addressId;
        this.totalAmount = totalAmount;
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

    public Set<ProductDto> getProductDtos() {
        return ProductDtos;
    }

    public void setProductDtos(Set<ProductDto> ProductDtos) {
        this.ProductDtos = ProductDtos;
    }
}
