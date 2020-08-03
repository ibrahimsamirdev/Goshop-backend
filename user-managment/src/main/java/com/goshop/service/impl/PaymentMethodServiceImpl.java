package com.goshop.service.impl;

import java.util.List;

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
	public List<PaymentMethod> getAllByUserId(long userId) {
		if (!userRepo.existsById(userId)) {
			throw new CustomException("User Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		return paymentMethodRepo.findByUserId(userId);
	}

	@Override
	public void addPaymentMethod(PaymentMethod paymentMethod) {
		if (!userRepo.existsById(paymentMethod.getUser().getId())) {
			throw new CustomException("User Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		paymentMethodRepo.save(paymentMethod);
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
