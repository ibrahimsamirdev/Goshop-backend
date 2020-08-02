package com.goshop.orderservice.model;


import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orders_id",nullable = false)
    private Orders orders;
    private long productId;
    private double price;
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

//    public Orders getOrders() {
//        return orders;
//    }

//    public void setOrders(Orders Orders) {
//        this.orders = Orders;
//    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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
