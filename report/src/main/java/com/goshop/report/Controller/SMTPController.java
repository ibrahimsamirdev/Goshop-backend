package com.goshop.report.Controller;

import com.goshop.report.dto.AdminReportProductDto;
import com.goshop.report.dto.MailDto;
import com.goshop.report.dto.ReportProductDto;
import com.goshop.report.feignproxy.ProductProxy;
import com.goshop.report.service.CreateReportService;
import com.goshop.report.service.mailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/email")
public class SMTPController {

    @Autowired
    mailSenderService mailSenderService;
    @Autowired
    CreateReportService createReportService;

    @Autowired
    ProductProxy productProxy;


    @PostMapping("/text")
    public ResponseEntity sendEamil(@Valid @RequestBody MailDto mailDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else
            mailSenderService.sendEmail(mailDto.getToEmail(), mailDto.getSubject(), mailDto.getBody());

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping("/emailAdminReport")
    public ResponseEntity sendEamilAdmin(@Valid @RequestBody MailDto mailDto, BindingResult bindingResult) throws IOException, MessagingException {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else
            createPdfAdmin();

            mailSenderService.sendEmailWithAttachment(mailDto.getToEmail(), mailDto.getSubject(),"Admin");
        System.out.println("pdf sent");
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    @PostMapping("/emailVendorReport/{id}")
    public ResponseEntity sendEamilVendor(@PathVariable String id,@Valid @RequestBody MailDto mailDto, BindingResult bindingResult) throws IOException, MessagingException {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else
            createPdfVendor(Long. parseLong(id));

        mailSenderService.sendEmailWithAttachment(mailDto.getToEmail(), mailDto.getSubject(),"Vendor");
        System.out.println("pdf sent");
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }






    private  void createPdfAdmin(){
        List<AdminReportProductDto> reportProductDtos=  productProxy.salesReportsAdmin();

        Map<String, String> parameters = new HashMap();

        parameters.put("createdBy", "Super Admin");

        String pathname = "E:\\MUM\\9-PM\\0-git-repo\\Goshop-backend\\report\\src\\main\\resources\\templates\\viewAdminSalesReports.jrxml";
        try {
            createReportService.createPdfReportSalesForEmail(reportProductDtos, parameters, pathname,"admin");
            System.out.println("pdf done");
        } catch (final Exception e) {

            e.printStackTrace();
        }
    }
    private  void createPdfVendor(Long vendorId){
        List<ReportProductDto>reportProductDtos=  productProxy.salesReportsVendor(vendorId);

        Map<String, String> parameters = new HashMap();

        parameters.put("createdBy", "Super Admin");

        String pathname = "E:\\MUM\\9-PM\\0-git-repo\\Goshop-backend\\report\\src\\main\\resources\\templates\\viewSalesReportsLive.jrxml";
        try {
            createReportService.createPdfReportSalesForEmail(reportProductDtos, parameters, pathname,"vendor");
            System.out.println("pdf done");
        } catch (final Exception e) {

            e.printStackTrace();
        }
    }
}
