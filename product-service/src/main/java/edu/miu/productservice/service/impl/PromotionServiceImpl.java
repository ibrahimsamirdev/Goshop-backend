package edu.miu.productservice.service.impl;

import java.time.LocalDate;
import java.util.List;

import edu.miu.productservice.exception.NoSuchResourceException;
import edu.miu.productservice.model.Promotion;
import edu.miu.productservice.repository.PromotionRepository;
import edu.miu.productservice.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	public List<Promotion> getAllPromotions() {
		 
		return promotionRepository.findAll();
	}

	@Override
	public Promotion updatePromotion(long promotionID, Promotion update_promotion) {
		Promotion promotion = promotionRepository.findById(promotionID).orElseThrow(() -> 
		new NoSuchResourceException("No Promotion found with", promotionID));
		
//		promotion.setProduct(update_promotion.getProduct());
		promotion.setStartDate(update_promotion.getStartDate());
		promotion.setEndDate(update_promotion.getEndDate());
		promotion.setDiscount(update_promotion.getDiscount());
		promotion.setTitle(update_promotion.getTitle());
		
		return promotionRepository.save(promotion);
	}

	@Override
	public Promotion deletePromotion(long promotionId) throws NoSuchResourceException {
		Promotion promotion = promotionRepository.findById(promotionId)
				.orElseThrow(() -> new NoSuchResourceException("No Promotion found  with", promotionId));

		if(promotion.isDeleted()){
			promotion.setDeleted(false);
		}else{
			promotion.setDeleted(true);
		}


		return promotionRepository.save(promotion);
	}

	@Override
	public List<Promotion> getVendorPormotions(Long vendoId) {
		return promotionRepository.findByVendorIdAndIsDeletedFalse(vendoId);
	}

	@Override
	public List<Promotion> getDeletedPromotions() {
		return promotionRepository.findByIsDeletedTrue();
	}

	@Override
	public List<Promotion> getNonDeletedPromotions() {
		return promotionRepository.findByIsDeletedFalse();
	}

	@Override
	public List<Promotion> getAllVendorValidPromotions(long vendorId) {
		return promotionRepository.findByStartDateLessThanAndEndDateGreaterThanAndVendorIdAndIsDeletedFalse(LocalDate.now(), LocalDate.now(), vendorId);
	}


}
