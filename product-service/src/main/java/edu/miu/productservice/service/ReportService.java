package edu.miu.productservice.service;

import edu.miu.productservice.model.Product;

import java.util.List;

public interface ReportService {

    public List<Product> getReportProduct(Long id);
}
