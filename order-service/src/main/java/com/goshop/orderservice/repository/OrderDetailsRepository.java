package com.goshop.orderservice.repository;

import com.goshop.orderservice.model.Order;
import com.goshop.orderservice.model.OrderDetails;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {

    @Query("SELECT d.id,d.price,d.quantity from OrderDetails d where d.productId=:id")
    Optional<Order> findProductIdById(@Param("id") Long id);
}
