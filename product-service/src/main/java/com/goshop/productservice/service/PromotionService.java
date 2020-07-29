package com.goshop.productservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.goshop.productservice.exception.NoSuchResourceException;
import com.goshop.productservice.model.Promotion;

public interface PromotionService {
	
	public Promotion addPromotion(Promotion promotion);
	public Promotion getPromotion(long promotionId) throws NoSuchResourceException;
	public List<Promotion> getPromotions();
	public Promotion updatePromotion(long promotionID, Promotion update_promotion);
	public ResponseEntity<Void> deletePromotion(long promotionId) throws NoSuchResourceException;

}
