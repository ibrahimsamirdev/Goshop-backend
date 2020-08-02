package com.goshop.orderservice.service;


import com.goshop.orderservice.model.Orders;

import java.util.List;
import java.util.Optional;


public interface OrderService {
    public List<Orders> getOrders(long userId);
    public Optional<Orders> getOrder(long orderId);
}
