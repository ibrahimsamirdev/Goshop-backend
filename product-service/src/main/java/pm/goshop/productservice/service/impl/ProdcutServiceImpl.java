package pm.goshop.productservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pm.goshop.productservice.bean.Product;
import pm.goshop.productservice.exception.NoSuchResourceException;
import pm.goshop.productservice.repository.ProductRepository;
import pm.goshop.productservice.service.ProductService;

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
	public Product updateProduct(long productID, Product update_product) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResponseEntity<Void> deleteProduct(long productId) throws NoSuchResourceException {
		// TODO Auto-generated method stub
		return null;
	}


}
