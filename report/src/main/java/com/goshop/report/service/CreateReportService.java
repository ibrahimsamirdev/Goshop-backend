package com.goshop.report.service;

import com.goshop.report.dto.AdminReportProductDto;
import com.goshop.report.dto.ReportProductDto;
import com.goshop.report.model.Employee;
import net.sf.jasperreports.engine.JRException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CreateReportService {

    public HttpServletResponse createPdfReport(HttpServletResponse response, List<Employee> dataList, Map parameters, String pathname) throws IOException, JRException;

    public HttpServletResponse createPdfReportSalesVendor(HttpServletResponse response, List<ReportProductDto> dataList, Map parameters, String pathname) throws IOException, JRException;

    public HttpServletResponse createPdfReportSalesAdmin(HttpServletResponse response, List<AdminReportProductDto> dataList, Map parameters, String pathname) throws IOException, JRException;
    public void  createPdfReportSalesForEmail(List dataList, Map parameters, String pathname ,String Type) throws IOException, JRException;
}
