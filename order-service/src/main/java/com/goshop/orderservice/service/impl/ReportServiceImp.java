package com.goshop.orderservice.service.impl;

import com.goshop.orderservice.model.OrderDetails;
import com.goshop.orderservice.model.Orders;
import com.goshop.orderservice.repository.OrderDetailsRepository;
import com.goshop.orderservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportServiceImp implements ReportService {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;


    @Override
    public int findByProduct(Long pId) {
        System.out.println("33 ========: "+pId +orderDetailsRepository.findProductIdById(pId) );
       return orderDetailsRepository.findProductIdById(pId);
        //return  orderDetailsRepository.findById(pId);
    }
}
