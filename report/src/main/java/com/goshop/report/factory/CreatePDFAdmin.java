package com.goshop.report.factory;

import com.goshop.report.dto.AdminReportProductDto;
import com.goshop.report.feignproxy.ProductProxy;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

@Service
public class CreatePDFAdmin implements CreatePDF {

    @Autowired
    ProductProxy productProxy;

    @Override
    public HttpServletResponse createPdfReport(HttpServletResponse response, Map parameters,String URLPram) throws IOException, JRException {
        List<AdminReportProductDto> dataList= productProxy.salesReportsAdmin();

        String pathname ="E:\\MUM\\9-PM\\0-git-repo\\Goshop-backend\\report\\src\\main\\resources\\templates\\viewAdminSalesReports.jrxml";

        // Fetching the .jrxml file from the folder.
        // final InputStream stream = this.getClass().getResourceAsStream("\\templates\\test.jrxml");
        final InputStream stream = new FileInputStream(new File(pathname));
        JasperDesign jasperDesign = JRXmlLoader.load(stream);
        // Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(jasperDesign);
        // creating datasource from bean list
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, beanColDataSource);
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        return response;
    }
}
