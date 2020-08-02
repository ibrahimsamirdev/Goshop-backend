package com.goshop.orderservice.DTO;

import java.util.List;

public class orderDto {
    private long userId;
    private long paymentId;
    private long addressId;
    private double totalAmount;
    private List<productDto> productDtos;

    public orderDto(){
    }

    public orderDto(long userId, long paymentId, long addressId, double totalAmount, List<productDto> productDtos) {
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

    public List<productDto> getProductDtos() {
        return productDtos;
    }

    public void setProductDtos(List<productDto> productDtos) {
        this.productDtos = productDtos;
    }
}
