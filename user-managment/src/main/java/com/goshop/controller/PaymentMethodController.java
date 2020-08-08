package com.goshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.goshop.model.PaymentMethod;
import com.goshop.service.PaymentMethodService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/paymentmethod")
public class PaymentMethodController {

	@Autowired
	private PaymentMethodService paymentMethodService;

	/**
	 * Get all payment methods
	 * 
	 * @return List of payment methods
	 */
	@GetMapping()
	public ResponseEntity<Object> getAllPaymentMethods() {
		List<PaymentMethod> paymentMethods = paymentMethodService.getAll();
		return new ResponseEntity<Object>(paymentMethods, HttpStatus.OK);
	}

	/**
	 * Get payment method by Id
	 * 
	 * @param id - payment method id
	 * @return payment method object
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getPaymentMethodById(@PathVariable long id) {
		PaymentMethod paymentMethod = paymentMethodService.getById(id);
		return new ResponseEntity<Object>(paymentMethod, HttpStatus.OK);
	}

	/**
	 * Add payment method
	 * 
	 * @param paymentMethod
	 * @return string "success"
	 */
	@PostMapping()
	public ResponseEntity<Object> addPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
		paymentMethodService.addPaymentMethod(paymentMethod);
		return new ResponseEntity<Object>("success", HttpStatus.CREATED);
	}

	/**
	 * Update payment method
	 * 
	 * @param paymentMethod
	 * @return string "success"
	 */
	@PutMapping()
	public ResponseEntity<Object> updatePaymentMethod(@RequestBody PaymentMethod paymentMethod) {
		paymentMethodService.updatePaymentMethod(paymentMethod);
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}

	/**
	 * Delete payment method
	 * 
	 * @param id - payment method id
	 * @return string "success"
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePaymentMethod(@PathVariable long id) {
		paymentMethodService.deletePaymentMethod(id);
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}
}
