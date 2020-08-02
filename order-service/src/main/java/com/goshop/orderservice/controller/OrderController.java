package com.goshop.orderservice.controller;

import com.goshop.orderservice.model.Orders;
import com.goshop.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
//    @GetMapping("user/{userId}")
//    public ResponseEntity<List<Order>> getOrders(@PathVariable String userId){
//
//
//        HttpHeaders headers = new HttpHeaders();
//
//        List<Order> orders=orderService.getOrders(Long.parseLong(userId));
//
//
//        if (orders == null || orders.isEmpty()) {
//            return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
//        }
//        System.out.println("Order " + orders.get(0).toString() );
//
//        headers.add("Number of Blocks returned", "22");
//        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
//
//    }


    @GetMapping(value = "/{orderId}")
    public  ResponseEntity<Object> getOrder(@PathVariable String orderId){
        Optional<Orders> order=orderService.getOrder(Long.parseLong(orderId));

        if (!order.isPresent()) {
            return new ResponseEntity< Object>(HttpStatus.NOT_FOUND);
        }

        System.out.println("Order " + order.get() );
        return new ResponseEntity<Object>(order.get(),HttpStatus.OK);
    }
}
