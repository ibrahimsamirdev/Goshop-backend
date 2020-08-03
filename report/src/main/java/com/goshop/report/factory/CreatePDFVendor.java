package com.goshop.report.factory;

import com.goshop.report.dto.AdminReportProductDto;
import com.goshop.report.dto.ReportProductDto;
import com.goshop.report.feignproxy.ProductProxy;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Component
public class CreatePDFVendor implements CreatePDF {

    final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductProxy productProxy;

    @Override
    public HttpServletResponse createPdfReport(HttpServletResponse response, Map parameters, String URLPram) throws IOException, JRException {
        System.out.println("rrrr");

        List<ReportProductDto>reportProductDtos=  productProxy.salesReportsVendor(1);

        System.out.println("reportProductDtos" + reportProductDtos.get(0).toString());
        String pathname ="E:\\MUM\\9-PM\\0-git-repo\\Goshop-backend\\report\\src\\main\\resources\\templates\\viewSalesReportsLive.jrxml";

        // Fetching the .jrxml file from the folder.
        // final InputStream stream = this.getClass().getResourceAsStream("\\templates\\test.jrxml");
        final InputStream stream = new FileInputStream(new File(pathname));
        JasperDesign jasperDesign = JRXmlLoader.load(stream);
        // Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(jasperDesign);
        // creating datasource from bean list
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(reportProductDtos);
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, beanColDataSource);
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        return response;
    }
}
