package com.goshop.orderservice.service;

import com.goshop.orderservice.model.OrderDetails;

import java.util.Optional;

public interface ReportService {
    public Optional<OrderDetails> findByProduct(Long pId);
}
