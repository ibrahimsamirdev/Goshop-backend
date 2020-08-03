package com.goshop.service;

import java.util.List;

import com.goshop.model.PaymentMethod;

public interface PaymentMethodService {

	List<PaymentMethod> getAll();

	PaymentMethod getById(long id);

	List<PaymentMethod> getAllByUserId(long userId);

	void addPaymentMethod(PaymentMethod paymentMethod);

	void updatePaymentMethod(PaymentMethod paymentMethod);

	void deletePaymentMethod(long id);
}
