package com.goshop.productservice.service.impl;

import java.util.List;

import com.goshop.productservice.model.Product;
import com.goshop.productservice.exception.NoSuchResourceException;
import com.goshop.productservice.repository.ProductRepository;
import com.goshop.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProdcutServiceImpl implements ProductService {
	
	@Autowired
    ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public Product getProduct(long productId) throws NoSuchResourceException {
		Product product = productRepository.findById(productId).orElseThrow(() -> 
		new NoSuchResourceException("No Product found  with" , productId));
		
		return product;
	}

	
	@Override
	public List<Product> getProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public Product editProduct(long productID, Product edit_product) {
		
		Product product = productRepository.findById(productID).orElseThrow(() -> 
		new  NoSuchResourceException("No product found  with" , productID));
		
		product.setAttributes(edit_product.getAttributes());
		product.setCategory(edit_product.getCategory());
		product.setCreationDate(edit_product.getCreationDate());
		product.setDescription(edit_product.getDescription());
		product.setImageUrl(edit_product.getImageUrl());
		product.setPrice(edit_product.getPrice());
		product.setTitle(edit_product.getTitle());
		product.setPublished(edit_product.isPublished());
		product.setStockAmount(edit_product.getStockAmount());
		
		
		return productRepository.save(product);
	}
	
	@Override
	public ResponseEntity<Void> deleteProduct(long productID) throws NoSuchResourceException {
		Product product = productRepository.findById(productID)
				.orElseThrow(() -> new NoSuchResourceException("No Prodcut found  with", productID));

		productRepository.delete(product);

		return ResponseEntity.noContent().build();
	}


}
