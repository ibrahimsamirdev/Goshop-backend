package pm.goshop.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pm.goshop.productservice.bean.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>	 {

}
