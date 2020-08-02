package com.goshop.orderservice.service;


import com.goshop.orderservice.model.Orders;
import java.util.Optional;
import java.util.Set;


public interface OrderService {
    public Set<Orders> getOrders(long userId);
    public Optional<Orders> getOrder(long orderId);
}
