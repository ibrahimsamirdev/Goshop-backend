package com.goshop.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goshop.orderservice.Configuration;
import com.goshop.orderservice.bean.OrderConfiguration;
import com.goshop.orderservice.feignproxy.ProductProxy;

@RestController
public class RestOrderTest {

    @Autowired
    Configuration config;

    @Autowired
    ProductProxy proxy;
    @GetMapping("/order/hello")
    public String testOrder(){
        return " Order Service hello";
    }

    @GetMapping("/order/order-service")
    public String testFiegnOrder(){
        return proxy.testRest()+ " from order";
    }

    @GetMapping("/order/config")
    public OrderConfiguration testRestConfig() {
        return new OrderConfiguration(config.getMinimum(), config.getMaximum());
    }

}
