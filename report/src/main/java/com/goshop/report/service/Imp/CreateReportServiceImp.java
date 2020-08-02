package com.goshop.report.service.Imp;

import com.goshop.report.dto.AdminReportProductDto;
import com.goshop.report.dto.ReportProductDto;
import com.goshop.report.model.Employee;
import com.goshop.report.service.CreateReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service
public class CreateReportServiceImp implements CreateReportService {
    @Override
    public HttpServletResponse createPdfReport(HttpServletResponse response, List<Employee> dataList, Map parameters, String pathname) throws IOException, JRException {

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

    @Override
    public HttpServletResponse createPdfReportSalesVendor(HttpServletResponse response, List<ReportProductDto> dataList, Map parameters, String pathname) throws IOException, JRException {
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

    @Override
    public HttpServletResponse createPdfReportSalesAdmin(HttpServletResponse response, List<AdminReportProductDto> dataList, Map parameters, String pathname) throws IOException, JRException {
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
