package com.goshop.report.feignproxy;

import com.goshop.report.dto.AdminReportProductDto;
import com.goshop.report.dto.ReportProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@FeignClient(value = "product-service",url = "http://localhost:8082")
public interface ProductProxy {

    @GetMapping("/report/salesForVendor/{vendorId}")
      List<ReportProductDto> salesReportsVendor(@PathVariable long vendorId);

    @GetMapping("/report/salesForAdmin")
    public List<AdminReportProductDto> salesReportsAdmin();
}
