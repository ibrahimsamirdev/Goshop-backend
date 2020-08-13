package com.goshop.orderservice.service.impl;

import com.goshop.orderservice.model.Orders;
import com.goshop.orderservice.repository.OrderRepository;
import com.goshop.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Set<Orders> getOrders(long userId){
        return orderRepository.findByUserId(userId);
    }


    public Optional<Orders> getOrder(long orderId){
        //System.out.println("orderRepository"+orderRepository.findById(orderId).get());
        return orderRepository.findById(orderId);
    }

    public Orders addOrder(Orders orders){
        orders.setCreationDate(LocalDate.now());
        return orderRepository.save(orders);
    }

}
