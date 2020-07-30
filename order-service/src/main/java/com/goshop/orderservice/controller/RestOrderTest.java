package com.goshop.orderservice.controller;

<<<<<<< HEAD:order-service/src/main/java/com/goshop/orderservice/controller/RestOrderTest.java
import com.goshop.orderservice.configuration.Configuration;
import com.goshop.orderservice.configuration.OrderConfiguration;
import com.goshop.orderservice.feignproxy.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goshop.orderservice.Configuration;
import com.goshop.orderservice.bean.OrderConfiguration;
import com.goshop.orderservice.feignproxy.ProductProxy;
>>>>>>> 0d197d81e037db7c090a9413c06f27777b9bb42d:order-service/src/main/java/edu/miu/orderservice/controller/RestOrderTest.java

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
