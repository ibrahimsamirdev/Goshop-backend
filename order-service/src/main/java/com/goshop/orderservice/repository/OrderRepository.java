package com.goshop.orderservice.repository;

import com.goshop.orderservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    public List<Orders> findByUserId(long userId);
}
