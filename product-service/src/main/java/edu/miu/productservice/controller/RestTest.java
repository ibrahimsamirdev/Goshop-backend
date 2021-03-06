package edu.miu.productservice.controller;

import edu.miu.productservice.configuration.Configuration;
import edu.miu.productservice.configuration.ProductConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTest {
    @Autowired
    Environment environment;
    @Autowired
    Configuration config;

    @GetMapping("/product/hello")
    public String testRest() {
        int port=Integer.parseInt(environment.getProperty("local.server.port"));
        return "hello product service port:"+port;
    }

    @GetMapping("/product/config")
    public ProductConfiguration testRestConfig() {
        return new ProductConfiguration(config.getMinimum(), config.getMaximum());
    }
}
