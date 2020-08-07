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
	public void createCreditCard(CreditCard card) {
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
