package com.goshop.report.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePDFFactory {
    @Autowired
    CreatePDFAdmin createPDFAdmin;
    @Autowired
    CreatePDFVendor createPDFVendor;
    public CreatePDF getPDF(String reportName) {
        if (reportName.equalsIgnoreCase("admin"))
            return createPDFAdmin;
        else if (reportName.equalsIgnoreCase("vendor"))
            return createPDFVendor;
        else
            return null;
    }
}
