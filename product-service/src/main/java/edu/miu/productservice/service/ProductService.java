package edu.miu.productservice.service;

import java.util.List;

import edu.miu.productservice.model.Product;
import edu.miu.productservice.exception.NoSuchResourceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
	public Product addProduct(Product product);
	public Product getProduct(long productId) throws NoSuchResourceException;
	public List<Product> getProducts();

	public Product editProduct(long productID, Product edit_product);
	public Product deleteProduct(long productId) throws NoSuchResourceException;
	Product updateStock(long soldAmount, long productId);

	//Andrew Advanced Search
	public List<Product> findByTitle(String title);
	public  List<Product> findByTitleAndDescription(String title,String description);
	public List<Product> findByCategoryName(String name);

	List<Product> getVendorProducts(long vendorId);

	Product createProductWithImage(MultipartFile image, Product product);

	Product updateProductWithImage(MultipartFile image, Product product);

	List<Product> getVendorPublishedProducts(long vendorId);

	List<Product> getVendorNonPublishedProducts(long vendorId);

	List<Product> getNonDeletedProducts();

	List<Product> getDeletedProducts();

	List<Product> getPublishedProducts();

	List<Product> getNonPublishedProducts();

}
