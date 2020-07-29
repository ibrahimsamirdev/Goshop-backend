package com.goshop.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goshop.productservice.model.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

}
