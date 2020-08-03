package edu.miu.productservice;

import edu.miu.productservice.dto.ReportProductDto;
import edu.miu.productservice.model.Product;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportProductDtoUnitTest {
    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertProductEntityToReportProductDto_thenCorrect() {
        Product  product = new Product();
        product.setTitle("title");
        product.setDescription("tititltit titt t");
        product.setPrice(10);
        product.setStockAmount(100);
        product.setSoldAmount(59);

        ReportProductDto reportProductDto = modelMapper.map(product, ReportProductDto.class);
        assertEquals(product.getTitle(), reportProductDto.getTitle());
        assertEquals(product.getPrice(), reportProductDto.getPrice());
        assertEquals(product.getStockAmount(), reportProductDto.getStockAmount());
    }

}
