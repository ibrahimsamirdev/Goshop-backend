package pm.goshop.productservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import pm.goshop.productservice.bean.Product;
import pm.goshop.productservice.exception.NoSuchResourceException;

public interface ProductService {
	public Product addProduct(Product product);
	public Product getProduct(long productId) throws NoSuchResourceException;
	public List<Product> getProducts();

	public Product updateBlock(long productID);
	public ResponseEntity<Void> deleteProduct(long productId) throws NoSuchResourceException;

}
