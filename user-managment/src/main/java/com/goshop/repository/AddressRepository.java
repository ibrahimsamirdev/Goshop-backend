package com.goshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goshop.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByUserId(long userId);

}
