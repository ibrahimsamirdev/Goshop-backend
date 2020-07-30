package edu.miu.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.productservice.model.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

}
