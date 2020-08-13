package edu.miu.productservice.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.miu.productservice.model.Category;
import edu.miu.productservice.model.Product;
import edu.miu.productservice.model.Promotion;
import edu.miu.productservice.service.ProductService;

@RestController
@CrossOrigin("*")
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

		// headers.add("Product added :", product.);

		return new ResponseEntity<Product>(product, headers, HttpStatus.CREATED);

	}

	// ResponseEntity<List<Product>>
	@GetMapping(value = "/")
	public ResponseEntity<List<Product>> getProducts() {

		HttpHeaders headers = new HttpHeaders();

		Product p = new Product(new Category("Fridge", "Haier", false, null), "Refridgerator", "small size", 100.00,
				LocalDate.now(), "15 inch", "image/fridge", 50, true, false, null);
		p.setPromotions(Arrays.asList(
				new Promotion("Christmas Promotion", new Date(2020, 12, 01), new Date(2020, 12, 30), 0.25),
				new Promotion("Easter Promotion", new Date(2020, 03, 01), new Date(2020, 04, 04), 0.15)));

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

	@PutMapping
	public ResponseEntity<Product> editProduct(@RequestBody Product product) {

		HttpHeaders headers = new HttpHeaders();
		Product product_toEdit = productService.getProduct(product.getId());

		if (product_toEdit == null) {

			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		Product updatedProduct = productService.editProduct(product.getId(), product);

		headers.add("Updated Block : ", String.valueOf(product.getId()));

		return new ResponseEntity<Product>(updatedProduct, headers, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{productId}")
	public Product deleteProduct(@PathVariable long productId) {

		return productService.deleteProduct(productId);

	}

	// Emad --- update for Order requirements
	@PutMapping(value = "/sold/{productId}/{soldAmount}")
	public boolean updateStock(@PathVariable long productId, @PathVariable long soldAmount) {

		System.out.println("=========== sold");

		Product product = productService.updateStock(soldAmount, productId);

		if (product == null)
			return false;
		else
			return true;
	}

	// Emad -- publish & unPublish
	@GetMapping(value = "/publish/{productId}")
	public ResponseEntity<Product> publishProduct(@PathVariable long productId) {

		HttpHeaders headers = new HttpHeaders();
		Product product_toEdit = productService.getProduct(productId);

		if (product_toEdit == null) {

			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		product_toEdit.setPublished(true);
		productService.addProduct(product_toEdit);

		headers.add("Updated Block : ", String.valueOf(productId));

		return new ResponseEntity<Product>(product_toEdit, headers, HttpStatus.OK);
	}

	@GetMapping(value = "/unPublish/{productId}")
	public ResponseEntity<Product> unPublishProduct(@PathVariable long productId) {

		HttpHeaders headers = new HttpHeaders();
		Product product_toEdit = productService.getProduct(productId);

		if (product_toEdit == null) {

			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		product_toEdit.setPublished(false);
		productService.addProduct(product_toEdit);

		headers.add("Updated Block : ", String.valueOf(productId));

		return new ResponseEntity<Product>(product_toEdit, headers, HttpStatus.OK);
	}

	// Andrew: - ADVANCED SEARCH find Product by title
	@GetMapping("/findByTitle/{title}")
	public List<Product> findByTitle(@PathVariable String title) {
		return productService.findByTitle(title);
	}

	@GetMapping("/findByTitleAndDescription/{title}/{description}")
	public List<Product> findByTitleAndDescription(@PathVariable String title, @PathVariable String description) {
		return productService.findByTitleAndDescription(title, description);
	}

	@GetMapping("/findByCategorysName/{name}")
	public List<Product> findByCategorysName(@PathVariable String name) {
		return productService.findByCategoryName(name);
	}

	@GetMapping("/vendor/{id}")
	public ResponseEntity<Object> getVendorProducts(@PathVariable("id") long id) {
		List<Product> products = productService.getVendorProducts(id);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/published/vendor/{id}")
	public ResponseEntity<Object> getVendorPublishedProducts(@PathVariable("id") long id) {
		List<Product> products = productService.getVendorPublishedProducts(id);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/nonPublished/vendor/{id}")
	public ResponseEntity<Object> getVendorNonPublishedProducts(@PathVariable("id") long id) {
		List<Product> products = productService.getVendorNonPublishedProducts(id);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@PostMapping("/uploadProduct")
	public ResponseEntity<Object> uploadProduct(@RequestParam("image") MultipartFile image,
			@RequestPart("product") Product product) {
//        List<Product> products =  productService.getVendorProducts(id);
		Product createdProduct = productService.createProductWithImage(image, product);
		return new ResponseEntity<>(createdProduct, HttpStatus.OK);
	}

	@PutMapping("/updateProductWithImage")
	public ResponseEntity<Object> updateProduct(@RequestParam("image") MultipartFile image,
			@RequestPart("product") Product product) {
//        List<Product> products =  productService.getVendorProducts(id);
		Product updatedProduct = productService.updateProductWithImage(image, product);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}

	@GetMapping("/published")
	public ResponseEntity<Object> getPublishedProducts() {
		List<Product> products = productService.getPublishedProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/nonPublished")
	public ResponseEntity<Object> getNonPublishedProducts() {
		List<Product> products = productService.getNonPublishedProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/deleted")
	public ResponseEntity<Object> getDeletedProducts() {
		List<Product> products = productService.getDeletedProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/nonDeleted")
	public ResponseEntity<Object> getNonDeletedProducts() {
		List<Product> products = productService.getNonDeletedProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<Object> getAllAddresses(@RequestParam String keyword, @RequestParam Long categoryid,
			@RequestParam Double minprice, @RequestParam Double maxprice) {
		List<Product> products = productService.search(keyword, categoryid, minprice, maxprice);
		return new ResponseEntity<Object>(products, HttpStatus.OK);
	}

    @PostMapping("/findAllProductIn")
        public ResponseEntity<Object> findAllProductIn(@RequestBody List<Long> ProductIds){
        System.out.println(">>>>>>>>>>>>>>>>>");
        System.out.println(ProductIds.toString());
        return new ResponseEntity<>( productService.findAllProductIn(ProductIds),new HttpHeaders(), HttpStatus.OK);
    }

}
