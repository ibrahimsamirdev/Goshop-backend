package edu.miu.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.miu.productservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT d from Product d where d.vendorId= :id order by d.id")
	List<Product> findRProductsByVendorId(@Param("id") Long id);

	@Query("SELECT d from Product d order by d.vendorId,d.id")
	List<Product> findRProductsAdmin();

	// ANDREW: Advanced Search

	// Simple derived query with parameters
	List<Product> findByTitle(String title);

	// Derived queries with multiple parameters
	List<Product> findByTitleAndDescription(String title, String description);

	// Traverse associations in derived queries
	List<Product> findByCategoryName(String title);

	List<Product> findByVendorIdAndIsDeletedFalse(long vendorId);

	List<Product> findProductByVendorIdAndIsPublishedTrueAndIsDeletedFalse(long vendorId);

	List<Product> findProductByVendorIdAndIsPublishedNotAndIsDeletedFalse(long vendorId, boolean t);

	List<Product> findProductByIsPublishedTrueAndIsDeletedFalse();

	List<Product> findProductByIsPublishedNotAndIsDeletedFalse(boolean t);

	List<Product> findByIsDeletedNot(boolean t);

	List<Product> findByIsDeletedTrue();

	@Query("SELECT p FROM Product p WHERE title LIKE %:keyword% "
			+ "AND (:categoryid is null or p.category.id = :categoryid) "
			+ "AND (:minprice is null or p.price >= :minprice) "
			+ "AND (:maxprice is null or p.price <= :maxprice) AND isPublished = true AND isDeleted = false")
	List<Product> searchProducts(String keyword, Long categoryid, Double minprice, Double maxprice);

    List<Product> findProductsByIdIn(List<Long> productIds);

}
