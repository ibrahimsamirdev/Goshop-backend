package com.goshop.orderservice.feignproxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "product-service")
@RibbonClient(name = "product-service")
public interface ProductProxy {

    @GetMapping("/product/hello")
    public  String testRest();

    @PutMapping(value = "/product/sold/{productId}/{soldAmount}")
    public boolean updateStock(@PathVariable long productId, @PathVariable long soldAmount);
}
