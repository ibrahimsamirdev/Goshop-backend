package edu.miu.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.productservice.model.Promotion;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {


    List<Promotion> findByVendorId(Long vendorId);

    List<Promotion> findByVendorIdAndIsDeletedFalse(Long vendorId);

    List<Promotion> findByIsDeletedFalse();

    List<Promotion> findByIsDeletedTrue();

    List<Promotion> findByStartDateLessThanAndEndDateGreaterThanAndVendorIdAndIsDeletedFalse(LocalDate t1, LocalDate d2, long vendorId);

}
