package com.goshop.orderservice.controller;

import com.goshop.orderservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Report {

    @Autowired
    ReportService reportService;

    @GetMapping("/salesByVendor")
    public int salesByVendor(){

        int orderDetails=   reportService.findByProduct((long) 1);

             return reportService.findByProduct((long) 1);


    }

    @GetMapping("/hello")
    public String hello(){
        return  "hello";
    }

}
