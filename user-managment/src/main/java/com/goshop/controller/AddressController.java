package com.goshop.controller;

import java.util.List;

import com.goshop.model.AddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.goshop.model.Address;
import com.goshop.service.AddressService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	/**
	 * Get all addresses
	 * 
	 * @return List of addresses
	 */
	@GetMapping()
	public ResponseEntity<Object> getAllAddresses() {
		List<Address> addresses = addressService.getAll();
		return new ResponseEntity<Object>(addresses, HttpStatus.OK);
	}

	/**
	 * Get all addresses of certain user
	 * 
	 * @return List of addresses by user id
	 */
	@GetMapping("/user/{userId}")
	public ResponseEntity<Object> getAllAddresses(@PathVariable long userId) {
		List<Address> addresses = addressService.getAllByUserId(userId);
		return new ResponseEntity<Object>(addresses, HttpStatus.OK);
	}

	@GetMapping("/user/shipping/{userId}")
	public ResponseEntity<Object> getShippingAddresses(@PathVariable long userId) {
		Address address = addressService.getUserByUserIdAndType(userId,AddressType.shipping);
		return  new ResponseEntity<Object>(address, HttpStatus.OK);
	}

	@GetMapping("/user/billing/{userId}")
	public Address getBillingAddresses(@PathVariable long userId) {
		Address address = addressService.getUserByUserIdAndType(userId, AddressType.billing);
		return address;
	}

	/**
	 * Get address by Id
	 * 
	 * @param id - address id
	 * @return address object
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getAddressById(@PathVariable long id) {
		Address address = addressService.getById(id);
		return new ResponseEntity<Object>(address, HttpStatus.OK);
	}

	/**
	 * Add address
	 * 
	 * @param address
	 * @return string "success"
	 */
	@PostMapping()
	public ResponseEntity<Object> addAddress(@RequestBody Address address) {

		return new ResponseEntity<Object>(addressService.addAddress(address), HttpStatus.CREATED);
	}

	/**
	 * Update address
	 * 
	 * @param address
	 * @return string "success"
	 */
	@PutMapping()
	public ResponseEntity<Object> updateAddress(@RequestBody Address address) {
		addressService.updateAddress(address);
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}

	/**
	 * Delete address
	 * 
	 * @param id - address id
	 * @return string "success"
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAddress(@PathVariable long id) {
		addressService.deleteAddress(id);
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}
}
