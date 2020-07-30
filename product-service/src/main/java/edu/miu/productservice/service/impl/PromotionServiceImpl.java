package com.goshop.productservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.goshop.productservice.exception.NoSuchResourceException;
import com.goshop.productservice.model.Promotion;
import com.goshop.productservice.repository.PromotionRepository;
import com.goshop.productservice.service.PromotionService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	PromotionRepository promotionRepository;
	
	@Override
	public Promotion addPromotion(Promotion promotion) {
		
		return promotionRepository.save(promotion);
	}

	@Override
	public Promotion getPromotion(long promotionId) throws NoSuchResourceException {
		
		Promotion promotion = promotionRepository.findById(promotionId).orElseThrow(() ->
		new NoSuchResourceException("No Promotion found with",promotionId));
		
		return promotion;
	}

	@Override
	public List<Promotion> getPromotions() {
		 
		return promotionRepository.findAll();
	}

	@Override
	public Promotion updatePromotion(long promotionID, Promotion update_promotion) {
		Promotion promotion = promotionRepository.findById(promotionID).orElseThrow(() -> 
		new NoSuchResourceException("No Promotion found with", promotionID));
		
		promotion.setProduct(update_promotion.getProduct());
		promotion.setStartDate(update_promotion.getStartDate());
		promotion.setEndDate(update_promotion.getEndDate());
		promotion.setDiscount(update_promotion.getDiscount());
		promotion.setTitle(update_promotion.getTitle());
		
		return promotionRepository.save(promotion);
	}

	@Override
	public ResponseEntity<Void> deletePromotion(long promotionId) throws NoSuchResourceException {
		Promotion promotion = promotionRepository.findById(promotionId)
				.orElseThrow(() -> new NoSuchResourceException("No Promotion found  with", promotionId));

		promotionRepository.delete(promotion);

		return ResponseEntity.noContent().build();
	}

	

}
