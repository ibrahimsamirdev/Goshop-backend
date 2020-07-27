package pm.goshop.orderservice.feignproxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "product-service")
@RibbonClient(name = "product-service")
public interface ProductProxy {

    @GetMapping("/product/hello")
    public  String testRest();
}
