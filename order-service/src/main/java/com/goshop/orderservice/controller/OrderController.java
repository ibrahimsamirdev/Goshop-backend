package com.goshop.orderservice.controller;

import com.goshop.orderservice.DTO.OrderDto;
import com.goshop.orderservice.model.OrderDetails;
import com.goshop.orderservice.model.Orders;
import com.goshop.orderservice.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/user/{userId}")
    public ResponseEntity<Set<Orders>> getOrders(@PathVariable String userId) {

        HttpHeaders headers = new HttpHeaders();
        Set<Orders> orders = orderService.getOrders(Long.parseLong(userId));

        if (orders == null || orders.isEmpty()) {
            return new ResponseEntity<Set<Orders>>(HttpStatus.NOT_FOUND);
        }

        headers.add("Number of Orders returned", String.valueOf(orders.size()));
        return new ResponseEntity<Set<Orders>>(orders, HttpStatus.OK);
    }


    @GetMapping(value = "/{orderId}")
    public ResponseEntity<Object> getOrder(@PathVariable String orderId) {

        System.out.println("========> "+ orderId);

        Optional<Orders> order = orderService.getOrder(Long.parseLong(orderId));

        if (!order.isPresent()) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }

        System.out.println("Order " + order.get());
        return new ResponseEntity<Object>(order.get(), HttpStatus.OK);
    }

    @PostMapping(value = "post/")
    public ResponseEntity<Orders> addOrder(@RequestBody Orders orders) {

//        HttpHeaders headers = new HttpHeaders();
//        Orders orders1=new Orders();
//        OrderDetails orderDetails=new OrderDetails();
//        orderDetails.setPrice(11);
//    orders1.addOrderDetail(orderDetails);
//        orders1.setTotalAmount(orders.getTotalAmount());
//        orders1.setOrderDetails(orders.getOrderDetails());
//        orders1.setPaymentId(orders.getPaymentId());


        if (orders == null) {
            return new ResponseEntity<Orders>(HttpStatus.BAD_REQUEST);
        }


        Orders createOrders = orderService.addOrder(orders);
        return new ResponseEntity<Orders>(createOrders, HttpStatus.CREATED);

//        return new ResponseEntity<OrderDto>(orderDto, headers, HttpStatus.CREATED);

    }

    @PostMapping(value = "/")
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) {

        HttpHeaders headers = new HttpHeaders();

        if (orderDto == null) {
            return new ResponseEntity<OrderDto>(HttpStatus.BAD_REQUEST);
        }

        Orders orders = convertToEntity(orderDto);
        Orders createOrders = orderService.addOrder(orders);
        return new ResponseEntity<OrderDto>(convertToDto(createOrders), headers, HttpStatus.CREATED);

//        return new ResponseEntity<OrderDto>(orderDto, headers, HttpStatus.CREATED);

    }

    private OrderDto convertToDto(Orders createOrders) {
        OrderDto orderDto = modelMapper.map(createOrders, OrderDto.class);
        return orderDto;
    }

    private Orders convertToEntity(OrderDto orderDto) {
        Orders orders = modelMapper.map(orderDto, Orders.class);
        return orders;
//        ModelMapper modelMapper = new ModelMapper();
//        TypeMap<OrderDto, Orders> typeMap = modelMapper.createTypeMap(OrderDto.class, Orders.class);
//        typeMap.addMappings(mapper -> {
//            mapper.map(orderDto::getOrderDetails, Orders::setOrderDetails);
//        });
    }

//    @GetMapping(value = "/cancleOrder/{orderId}")
//    public ResponseEntity<OrderDto> addOrder(@PathVariable String orderId) {
//
//    }


}

