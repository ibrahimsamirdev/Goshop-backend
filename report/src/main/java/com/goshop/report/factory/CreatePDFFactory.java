package com.goshop.report.factory;

import org.springframework.stereotype.Component;

@Component
public class CreatePDFFactory {
    public CreatePDF getPDF(String reportName) {
        if (reportName.equalsIgnoreCase("admin"))
            return new CreatePDFAdmin();
        else if (reportName.equalsIgnoreCase("vendor"))
            return new CreatePDFVendor();
        else
            return null;
    }
}
