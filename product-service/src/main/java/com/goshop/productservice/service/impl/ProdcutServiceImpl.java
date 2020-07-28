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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateBlock(long productID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> deleteProduct(long productId) throws NoSuchResourceException {
		// TODO Auto-generated method stub
		return null;
	}

}
