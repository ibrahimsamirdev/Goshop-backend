package edu.miu.productservice.controller;

import edu.miu.productservice.dto.AdminReportProductDto;
import edu.miu.productservice.dto.ReportProductDto;
import edu.miu.productservice.model.Product;
import edu.miu.productservice.service.ReportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/report")
public class ReportProductController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    ReportService reportService;

    @GetMapping("/salesForVendor/{vendorId}")
    public List<ReportProductDto> salesReportsVendor(@PathVariable long vendorId) {
        List<Product> products = reportService.getReportProduct(vendorId);

        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/salesForAdmin")
    public List<AdminReportProductDto> salesReportsAdmin() {
        List<Product> products = reportService.getReportProductForAdmin();

        return products.stream()
                .map(this::convertToDtoAdmin)
                .collect(Collectors.toList());
    }

    private AdminReportProductDto convertToDtoAdmin(Product product) {
        return modelMapper.map(product, AdminReportProductDto.class);
    }

    private ReportProductDto convertToDto(Product product) {
        ReportProductDto reportProductDto = modelMapper.map(product, ReportProductDto.class);
        return reportProductDto;
    }
}
