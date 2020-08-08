package com.goshop.service;

import java.util.List;

import com.goshop.DTO.createTransactionDTO;
import com.goshop.model.Transaction;

public interface TransactionService {

	List<Transaction> getAll();

	List<Transaction> getAllByCreditCardNo(long cardNo);

	Transaction getById(long id);

	void createTransaction(createTransactionDTO transaction);

}
