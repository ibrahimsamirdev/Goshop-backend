package com.goshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goshop.model.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

//	List<PaymentMethod> findByUserId(long userId);

	Optional<PaymentMethod> findByUserId(long userId);



}
