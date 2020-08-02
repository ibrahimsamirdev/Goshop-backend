package com.goshop.orderservice.repository;

import com.goshop.orderservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
    public Set<Orders> findByUserId(long userId);
}
