package com.goshop.service;

import java.util.List;

import com.goshop.model.CreditCard;

public interface CreditCardService {

	List<CreditCard> getAll();

	CreditCard getById(long id);

	void createCreditCard(CreditCard card);

	void deleteCreditCard(long id);

}
