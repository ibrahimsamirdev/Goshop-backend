package com.goshop.service.impl;

import java.util.List;

import com.goshop.model.AddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.goshop.exception.CustomException;
import com.goshop.model.Address;
import com.goshop.repository.AddressRepository;
import com.goshop.repository.UserRepository;
import com.goshop.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepo;

	@Autowired
	UserRepository userRepo;

	@Override
	public List<Address> getAll() {
		return addressRepo.findAll();
	}

	@Override
	public Address getById(long id) {
		return addressRepo.findById(id)
				.orElseThrow(() -> new CustomException("Address Not Found", HttpStatus.NOT_FOUND));
	}

	@Override
	public List<Address> getAllByUserId(long userId) {
		if (!userRepo.existsById(userId)) {
			throw new CustomException("User Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		return addressRepo.findByUserId(userId);
	}

	@Override
	public Address getUserByUserIdAndType(long userId, AddressType type){
		if (!userRepo.existsById(userId)) {
			throw new CustomException("User Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		return addressRepo.findByUserIdAndType(userId,type);
	}

	@Override
	public void addAddress(Address address) {
		if (!userRepo.existsById(address.getUser().getId())) {
			throw new CustomException("User Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		addressRepo.save(address);
	}

	@Override
	public void updateAddress(Address address) {
		if (!userRepo.existsById(address.getUser().getId())) {
			throw new CustomException("User Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		addressRepo.save(address);
	}

	@Override
	public void deleteAddress(long id) {
		if (!addressRepo.existsById(id)) {
			throw new CustomException("Payment Method Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		addressRepo.deleteById(id);
	}

}
