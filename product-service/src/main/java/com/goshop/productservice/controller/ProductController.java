package com.goshop.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goshop.productservice.model.Product;
import com.goshop.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@PostMapping(value = "/")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {

		HttpHeaders headers = new HttpHeaders();

		if (product == null) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
		productService.addProduct(product);

		//headers.add("Product added :", product.);

		return new ResponseEntity<Product>(product, headers, HttpStatus.CREATED);

	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Product>> getProducts(){
		
		HttpHeaders headers = new HttpHeaders();

		List<Product> products = productService.getProducts();

		if (products == null) {
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		headers.add("Number of Blocks returned", String.valueOf(products.size()));

		return new ResponseEntity<List<Product>>(products, headers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable long productId) {

		Product product = productService.getProduct(productId);

		if (product == null) {

			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

}
