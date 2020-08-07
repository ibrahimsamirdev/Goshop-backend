package com.goshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goshop.model.CreditCard;
import com.goshop.service.CreditCardService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/creditcard")
public class CreditCardController {
	@Autowired
	CreditCardService creditCardService;

	@GetMapping("/test")
	public String test() {
		return "Banking Microservice is running";
	}

	/**
	 * Get all Credit Cards
	 * 
	 * @return List of Credit Cards objects
	 */
	@GetMapping()
	public ResponseEntity<Object> getAllCreditCards() {
		List<CreditCard> cards = creditCardService.getAll();
		return new ResponseEntity<Object>(cards, HttpStatus.OK);
	}

	/**
	 * Get Credit Card by Id
	 * 
	 * @param id - Credit Card id
	 * @return Credit Card object
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCreditCardById(@PathVariable long id) {
		CreditCard card = creditCardService.getById(id);
		return new ResponseEntity<Object>(card, HttpStatus.OK);
	}

	/**
	 * Create Credit Card
	 *
	 * @param card - the Credit Card to be created
	 * @return string "success"
	 */
	@PostMapping()
	public ResponseEntity<Object> createCreditCard(@RequestBody CreditCard card) {
		creditCardService.createCreditCard(card);
		return new ResponseEntity<Object>("success", HttpStatus.CREATED);
	}

	/**
	 * Delete Credit Card
	 * 
	 * @param id - Credit Card id
	 * @return string "success"
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCreditCard(@PathVariable long id) {
		creditCardService.deleteCreditCard(id);
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}
}
