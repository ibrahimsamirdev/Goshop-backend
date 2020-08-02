package com.goshop.report.Controller;

import com.goshop.report.model.Employee;
import com.goshop.report.service.CreateReportService;
import com.goshop.report.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api")
public class EmployeeController {

    final Logger log = LoggerFactory.getLogger(this.getClass());
    final ModelAndView model = new ModelAndView();

    @Autowired
    EmployeeService eservice;

    @Autowired
    CreateReportService createReportService;



    @GetMapping(value = "/serviceTest")
    public void getDocumentnew(HttpServletResponse response) {
        log.info("Preparing the pdf report via jasper.");

        List<Employee> dataList = eservice.findAll();
        Map <String,String> parameters = new HashMap();

        parameters.put("createdBy","sony");

        String pathname = "E:\\MUM\\9-PM\\0-git-repo\\Goshop-backend\\report\\src\\main\\resources\\templates\\viewSalesReports.jrxml";
        try {
            response = createReportService.createPdfReport(response, dataList, parameters, pathname);
            log.info("Report create in response successfully saved at response.");

        } catch (final Exception e) {
            log.error("Some error has occurred while preparing Creating pdf report.");
            e.printStackTrace();
        }
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
    }

}
