package com.goshop.report.factory;

import net.sf.jasperreports.engine.JRException;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface CreatePDF {

    public HttpServletResponse createPdfReport(HttpServletResponse response, Map parameters,String URLPram) throws IOException, JRException;

}
