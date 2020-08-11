package com.goshop.service;

import java.util.List;

import com.goshop.model.Address;
import com.goshop.model.AddressType;

public interface AddressService {

	List<Address> getAll();

	Address getById(long id);

	List<Address> getAllByUserId(long userId);

	Address getUserByUserIdAndType(long userId, AddressType type);

	void addAddress(Address address);

	void updateAddress(Address address);

	void deleteAddress(long id);
}
