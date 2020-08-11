package com.goshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.goshop.exception.CustomException;
import com.goshop.model.PaymentMethod;
import com.goshop.repository.PaymentMethodRepository;
import com.goshop.repository.UserRepository;
import com.goshop.service.PaymentMethodService;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

	@Autowired
	PaymentMethodRepository paymentMethodRepo;

	@Autowired
	UserRepository userRepo;

	@Override
	public List<PaymentMethod> getAll() {
		return paymentMethodRepo.findAll();
	}

	@Override
	public PaymentMethod getById(long id) {
		return paymentMethodRepo.findById(id)
				.orElseThrow(() -> new CustomException("Payment Method Not Found", HttpStatus.NOT_FOUND));
	}

	@Override
	public PaymentMethod getByUserId(long userId) {
		if (!userRepo.existsById(userId)) {
			throw new CustomException("User Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		Optional<PaymentMethod> p = paymentMethodRepo.findByUserId(userId);
		return p.get();
	}

	@Override
	public PaymentMethod addPaymentMethod(PaymentMethod paymentMethod) {
		if (!userRepo.existsById(paymentMethod.getUser().getId())) {
			throw new CustomException("User Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		boolean isValid = true;
		// call paymentMicroservives to check thecard is avlid
		if(isValid){
			return  paymentMethodRepo.save(paymentMethod);
		}else{
			throw new CustomException("Card is not Valid ",HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@Override
	public void updatePaymentMethod(PaymentMethod paymentMethod) {
		if (!userRepo.existsById(paymentMethod.getUser().getId())) {
			throw new CustomException("User Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		paymentMethodRepo.save(paymentMethod);
	}

	@Override
	public void deletePaymentMethod(long id) {
		if (!paymentMethodRepo.existsById(id)) {
			throw new CustomException("Payment Method Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		paymentMethodRepo.deleteById(id);
	}

}
