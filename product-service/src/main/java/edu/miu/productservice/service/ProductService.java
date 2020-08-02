package edu.miu.productservice.service;

import java.util.List;

import edu.miu.productservice.model.Product;
import edu.miu.productservice.exception.NoSuchResourceException;
import org.springframework.http.ResponseEntity;

public interface ProductService {
	public Product addProduct(Product product);
	public Product getProduct(long productId) throws NoSuchResourceException;
	public List<Product> getProducts();

	public Product editProduct(long productID, Product edit_product);
	public Product deleteProduct(long productId) throws NoSuchResourceException;
    public Product updateStock(long soldAmount,long productID);
}
