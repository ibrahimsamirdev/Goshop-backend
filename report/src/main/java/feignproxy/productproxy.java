package feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "product-service",url = "http://localhost:8082")
public interface productproxy {

    @GetMapping(value = "/report")
    public void getscouce();
}
