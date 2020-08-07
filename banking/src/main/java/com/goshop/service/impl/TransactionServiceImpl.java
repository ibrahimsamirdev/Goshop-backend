package com.goshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goshop.DTO.createTransactionDTO;
import com.goshop.exception.CustomException;
import com.goshop.model.CreditCard;
import com.goshop.model.Transaction;
import com.goshop.repository.TransactionRepository;
import com.goshop.service.CreditCardService;
import com.goshop.service.TransactionService;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionRepository transactionRepo;

	@Autowired
	CreditCardService creditCardService;

	@Override
	public List<Transaction> getAll() {
		return transactionRepo.findAll();
	}

	@Override
	public Transaction getById(long id) {
		return transactionRepo.findById(id)
				.orElseThrow(() -> new CustomException("Transaction Not Found", HttpStatus.NOT_FOUND));
	}

	@Override
	public void createTransaction(createTransactionDTO transactionDTO) {
		CreditCard creditCard = creditCardService.getByCardNo(transactionDTO.getCardNo());
		if (transactionDTO.getAmount() > creditCard.getAvailableCredit()) {
			throw new CustomException("No sufficient credit available", HttpStatus.NOT_ACCEPTABLE);
		}
		Transaction transaction = new Transaction(transactionDTO.getAmount(), transactionDTO.getTransactionDate(),
				creditCard);
		transactionRepo.save(transaction);
		creditCard.setAvailableCredit(creditCard.getAvailableCredit() - transactionDTO.getAmount());
		creditCardService.createCreditCard(creditCard);
	}

	@Override
	public List<Transaction> getAllByCreditCardNo(long cardNo) {
		return null;
	}

}
