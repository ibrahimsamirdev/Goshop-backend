package com.goshop.report.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "order-service", url = "http://localhost:8000")
public interface OrderProxy {

    @GetMapping(value = "/report")
    public void getscouce();
}
