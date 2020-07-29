package com.goshop.productservice.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.goshop.productservice.exception.NoSuchResourceException;
import com.goshop.productservice.model.Promotion;
import com.goshop.productservice.service.PromotionService;

public class PromotionServiceImpl implements PromotionService {

	@Override
	public Promotion addPromotion(Promotion promotion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promotion getPromotion(long promotionId) throws NoSuchResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promotion> getPromotions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promotion updatePromotion(long promotionID, Promotion update_promotion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> deletePromotion(long promotionId) throws NoSuchResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
