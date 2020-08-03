package edu.miu.productservice.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import edu.miu.productservice.model.Category;
import edu.miu.productservice.model.Product;
import edu.miu.productservice.model.Promotion;
import edu.miu.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

    //ResponseEntity<List<Product>>
    @GetMapping(value = "/")
    public ResponseEntity<List<Product>> getProducts() {

        HttpHeaders headers = new HttpHeaders();

        Product p = new Product(new Category("Fridge", "Haier"), "Refridgerator", "small size", 100.00, new Date(), "15 inch", "image/fridge", 50, true, false, null);
        p.setPromotions(
                Arrays.asList(
                        new Promotion("Christmas Promotion", new Date(2020, 12, 01), new Date(2020, 12, 30), 0.25),
                        new Promotion("Easter Promotion", new Date(2020, 03, 01), new Date(2020, 04, 04), 0.15)
                ));

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

    @PutMapping(value = "/{productId}")
    public ResponseEntity<Product> editProduct(@PathVariable long productId, @RequestBody Product product) {

        HttpHeaders headers = new HttpHeaders();
        Product product_toEdit = productService.getProduct(productId);

        if (product_toEdit == null) {

            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        productService.editProduct(productId, product);

        headers.add("Updated Block : ", String.valueOf(productId));

        return new ResponseEntity<Product>(product, headers, HttpStatus.OK);
    }


    @DeleteMapping(value = "/{productId}")
    public Product deleteProduct(@PathVariable long productId) {

        return productService.deleteProduct(productId);


    }
     //Emad --- update for Order requirements
    @PutMapping(value = "/sold/{productId}/{soldAmount}")
    public boolean updateStock( @PathVariable long productId, @PathVariable long soldAmount) {

		System.out.println("=========== sold");

        Product product = productService.updateStock(soldAmount, productId);

        if (product == null)
            return false;
        else
            return true;
    }

    //Emad -- publish & unPublish
    @PutMapping(value = "publish/{productId}")
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

    @PutMapping(value = "unPublish/{productId}")
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


}
