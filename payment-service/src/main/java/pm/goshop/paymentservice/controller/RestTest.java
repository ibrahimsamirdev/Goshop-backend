package pm.goshop.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pm.goshop.paymentservice.Configuration;
import pm.goshop.paymentservice.bean.PaymentConfiguration;

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
