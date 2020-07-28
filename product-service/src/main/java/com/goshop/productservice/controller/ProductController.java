package com.goshop.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goshop.productservice.bean.Product;
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

}
