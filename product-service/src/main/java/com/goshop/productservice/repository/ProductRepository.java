package com.goshop.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goshop.productservice.bean.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>	 {

}
