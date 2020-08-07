package com.goshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goshop.DTO.createTransactionDTO;
import com.goshop.model.Transaction;
import com.goshop.service.TransactionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/transaction")
public class TransactionController {
	@Autowired
	TransactionService transactionService;

	/**
	 * Get all Transactions
	 * 
	 * @return List of Transaction objects
	 */
	@GetMapping()
	public ResponseEntity<Object> getAllTransactions() {
		List<Transaction> cards = transactionService.getAll();
		return new ResponseEntity<Object>(cards, HttpStatus.OK);
	}

	/**
	 * Get all Transactions By Card Number
	 * 
	 * @return List of Transaction objects for certain card
	 */
	@GetMapping("cardnumber/{cardNo}")
	public ResponseEntity<Object> getAllTransactionsByCardNo(@PathVariable long cardNo) {
		List<Transaction> cards = transactionService.getAllByCreditCardNo(cardNo);
		return new ResponseEntity<Object>(cards, HttpStatus.OK);
	}

	/**
	 * Get Transaction by Id
	 * 
	 * @param id - Transaction id
	 * @return Transaction object
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getTransactionById(@PathVariable long id) {
		Transaction card = transactionService.getById(id);
		return new ResponseEntity<Object>(card, HttpStatus.OK);
	}

	/**
	 * Create Transaction
	 *
	 * @param Transaction - the Transaction to be created
	 * @return string "success"
	 */
	@PostMapping()
	public ResponseEntity<Object> createTransaction(@RequestBody createTransactionDTO transactionDTO) {
		transactionService.createTransaction(transactionDTO);
		return new ResponseEntity<Object>("success", HttpStatus.CREATED);
	}

}
