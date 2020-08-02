package edu.miu.productservice.repository;

import edu.miu.productservice.dto.ReportProductDto;
import edu.miu.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>	 {

   // d.id,d.title,d.description,d.price,d.stockAmount,d.stockAmount
    @Query("SELECT d from Product d where d.VendorId= :id order by d.id")
    List<Product> findRProductsByVendorId(@Param("id") Long id );
}
