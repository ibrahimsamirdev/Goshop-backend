package com.goshop.report.Controller;

import com.goshop.report.dto.ReportProductDto;
import com.goshop.report.service.CreateReport;
import com.goshop.report.feignproxy.ProductProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/report")
public class salesReportsVendorController {

    final Logger log = LoggerFactory.getLogger(this.getClass());
    final ModelAndView model = new ModelAndView();


    @Autowired
    CreateReport createReport;

    @Autowired
    ProductProxy productProxy;

    @GetMapping(value = "/ReportSales")
    public void getDocumentnew(HttpServletResponse response) {
        log.info("Preparing the pdf report via jasper.");

       List<ReportProductDto>reportProductDtos=  productProxy.salesReportsVendor(1);
        log.info("returned data from proxy successfully");

        Map<String, String> parameters = new HashMap();

        parameters.put("createdBy", "test");

        String pathname = "E:\\MUM\\9-PM\\0-git-repo\\Goshop-backend\\report\\src\\main\\resources\\templates\\viewSalesReportsLive.jrxml";
        try {
            response = createReport.createPdfReportSalesVendor(response, reportProductDtos, parameters, pathname);
            log.info("Report create in response successfully saved at response.");

        } catch (final Exception e) {
            log.error("Some error has occurred while preparing Creating pdf report.");
            e.printStackTrace();
        }
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
    }
}
