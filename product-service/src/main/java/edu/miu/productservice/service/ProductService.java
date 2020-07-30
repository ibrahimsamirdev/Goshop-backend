package com.goshop.productservice.service;

import java.util.List;

import com.goshop.productservice.model.Product;
import org.springframework.http.ResponseEntity;

import com.goshop.productservice.exception.NoSuchResourceException;

public interface ProductService {
	public Product addProduct(Product product);
	public Product getProduct(long productId) throws NoSuchResourceException;
	public List<Product> getProducts();

	public Product editProduct(long productID, Product edit_product);
	public ResponseEntity<Void> deleteProduct(long productId) throws NoSuchResourceException;

}
