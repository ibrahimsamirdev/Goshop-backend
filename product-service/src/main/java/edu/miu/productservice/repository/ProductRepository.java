package edu.miu.productservice.repository;

import edu.miu.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT d from Product d where d.vendorId= :id order by d.id")
    List<Product> findRProductsByVendorId(@Param("id") Long id);

    @Query("SELECT d from Product d order by d.vendorId,d.id")
    List<Product> findRProductsAdmin();
}
