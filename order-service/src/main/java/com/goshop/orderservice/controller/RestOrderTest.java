package edu.miu.orderservice.controller;

import edu.miu.orderservice.configuration.Configuration;
import edu.miu.orderservice.feignproxy.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.miu.orderservice.configuration.OrderConfiguration;

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
