package com.goshop.report.Controller;

import com.goshop.report.factory.CreatePDFFactory;
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
import java.util.Map;

@RestController
@RequestMapping(value = "/reportWithFactory")
public class SalesReportFController {

    final Logger log = LoggerFactory.getLogger(this.getClass());
    final ModelAndView model = new ModelAndView();

    @Autowired
    CreatePDFFactory factory;

    @GetMapping(value = "/VendorReportSales/{id}")
    public void getSalesReport(HttpServletResponse response, @PathVariable String id) {
        log.info("Preparing the pdf report via jasper.");
        Map<String, String> parameters = new HashMap();

        parameters.put("createdBy", "sony");
        try {

            response = factory.getPDF("vendor").createPdfReport(response, parameters, id);
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
        Map<String, String> parameters = new HashMap();

        parameters.put("createdBy", "SuperAdmin");
        try {

            response = factory.getPDF("admin").createPdfReport(response, parameters, "");
            log.info("Report create in response successfully saved at response.");

        } catch (final Exception e) {
            log.error("Some error has occurred while preparing Creating pdf report.");
            e.printStackTrace();
        }
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
    }


}
