package com.goshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.goshop.exception.CustomException;
import com.goshop.model.CreditCard;
import com.goshop.repository.CreditCardRepository;
import com.goshop.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {
	@Autowired
	CreditCardRepository creditCardRepo;

	@Override
	public List<CreditCard> getAll() {
		return creditCardRepo.findAll();
	}

	@Override
	public CreditCard getById(long id) {
		return creditCardRepo.findById(id)
				.orElseThrow(() -> new CustomException("Credit Card Not Found", HttpStatus.NOT_FOUND));
	}

	@Override
	public CreditCard getByCardNo(long cardNo) {
		return creditCardRepo.findByCardNo(cardNo)
				.orElseThrow(() -> new CustomException("Credit Card Doesn't Exist", HttpStatus.NOT_FOUND));
	}

	@Override
	public void createCreditCard(CreditCard card) {
		if (card.getCreditLine() <= 0) {
			throw new CustomException("Credit Line can't be less than or equal to Zero", HttpStatus.NOT_ACCEPTABLE);
		}
		if (card.getAvailableCredit() > card.getCreditLine()) {
			throw new CustomException("Available Credit can't be greater than Credit Limit", HttpStatus.NOT_ACCEPTABLE);
		}
		creditCardRepo.save(card);
	}

	@Override
	public void deleteCreditCard(long id) {
		if (!creditCardRepo.existsById(id)) {
			throw new CustomException("Credit Card Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		creditCardRepo.deleteById(id);
	}

}
