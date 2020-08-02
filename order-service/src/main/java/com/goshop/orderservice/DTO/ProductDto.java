package com.goshop.orderservice.DTO;

public class ProductDto {
    private long productId;
    private double price;
    private int quantity;

    public ProductDto(){
    }

    public ProductDto(long productId, double price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() {
        return productId;
    }

    public void setId(long id) {
        this.productId = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
