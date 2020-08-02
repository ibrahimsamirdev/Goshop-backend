package com.goshop.orderservice.controller;

import com.goshop.orderservice.DTO.OrderDto;
import com.goshop.orderservice.model.Orders;
import com.goshop.orderservice.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
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

    @PostMapping(value = "/")
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) {

        HttpHeaders headers = new HttpHeaders();

        if (orderDto == null) {
            return new ResponseEntity<OrderDto>(HttpStatus.BAD_REQUEST);
        }

        Orders orders = convertToEntity(orderDto);
        Orders createOrders = orderService.addOrder(orders);
        return new ResponseEntity<OrderDto>(convertToDto(createOrders), headers, HttpStatus.CREATED);

    }

    private OrderDto convertToDto(Orders createOrders) {
        OrderDto orderDto = modelMapper.map(createOrders, OrderDto.class);
        return orderDto;
    }

    private Orders convertToEntity(OrderDto orderDto) {
        Orders orders = modelMapper.map(orderDto, Orders.class);
        return orders;
    }


}

