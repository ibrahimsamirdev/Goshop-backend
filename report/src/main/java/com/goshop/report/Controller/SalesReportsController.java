package com.goshop.report.Controller;

import com.goshop.report.dto.AdminReportProductDto;
import com.goshop.report.dto.ReportProductDto;
import com.goshop.report.service.CreateReportService;
import com.goshop.report.feignproxy.ProductProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/report")
public class SalesReportsController {

    final Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    CreateReportService createReportService;

    @Autowired
    ProductProxy productProxy;

    @GetMapping(value = "/VendorReportSales/{id}")
    public void getSalesReport(HttpServletResponse response, @PathVariable String id) {
        log.info("Preparing the pdf report via jasper.");

       List<ReportProductDto>reportProductDtos=  productProxy.salesReportsVendor(Long. parseLong(id));
        log.info("returned data from proxy successfully");

        Map<String, String> parameters = new HashMap();

        parameters.put("createdBy", "test");

        String pathname = "E:\\MUM\\9-PM\\0-git-repo\\Goshop-backend\\report\\src\\main\\resources\\templates\\viewSalesReportsLive.jrxml";
        try {
            response = createReportService.createPdfReportSalesVendor(response, reportProductDtos, parameters, pathname);
            log.info("Report create in response successfully saved at response.");

        } catch (final Exception e) {
            log.error("Some error has occurred while preparing Creating pdf report.");
            e.printStackTrace();
        }
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
    }

    @GetMapping(value = "/AdminReportSales")
    public void getAdminSalesReport(HttpServletResponse response) {
        log.info("Preparing the pdf report via jasper.");

        List<AdminReportProductDto> reportProductDtos=  productProxy.salesReportsAdmin();
        log.info("returned data from proxy successfully");

        Map<String, String> parameters = new HashMap();

        parameters.put("createdBy", "Super Admin");

        String pathname = "E:\\MUM\\9-PM\\0-git-repo\\Goshop-backend\\report\\src\\main\\resources\\templates\\viewAdminSalesReports.jrxml";
        try {
            response = createReportService.createPdfReportSalesAdmin(response, reportProductDtos, parameters, pathname);
            log.info("Report create in response successfully saved at response.");

        } catch (final Exception e) {
            log.error("Some error has occurred while preparing Creating pdf report.");
            e.printStackTrace();
        }
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
    }
}
