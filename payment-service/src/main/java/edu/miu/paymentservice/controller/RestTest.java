package edu.miu.paymentservice.controller;

import edu.miu.paymentservice.Configuration;
import edu.miu.paymentservice.bean.PaymentConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTest {
    @Autowired
    Configuration config;

    @GetMapping("/payment/hello")
    public String test(){
        return "Hello Payment Service";
    }

    @GetMapping("/payment/config")
    public PaymentConfiguration testRestConfig() {
        return new PaymentConfiguration(config.getMinimum(), config.getMaximum());
    }
}
