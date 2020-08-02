package edu.miu.productservice.service.impl;

import java.util.List;

import edu.miu.productservice.model.Product;
import edu.miu.productservice.exception.NoSuchResourceException;
import edu.miu.productservice.repository.ProductRepository;
import edu.miu.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		product.setDeleted(edit_product.isDeleted());


		return productRepository.save(product);
	}

	@Override
	public Product deleteProduct(long productID) throws NoSuchResourceException {
		Product product = productRepository.findById(productID)
				.orElseThrow(() -> new NoSuchResourceException("No Product found  with", productID));

		product.setDeleted(true);
		productRepository.save(product);

		return productRepository.save(product);
	}

	public Product updateStock(long soldAmount,long productID){
		Product product = productRepository.findById(productID)
				.orElseThrow(() -> new NoSuchResourceException("No Product found  with", productID));

		long newStockAmount = product.getStockAmount() - soldAmount;
		product.setStockAmount(newStockAmount);


		return productRepository.save(product);
	}


}
