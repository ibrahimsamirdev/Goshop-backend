package edu.miu.productservice.service;

import java.util.List;

import edu.miu.productservice.exception.NoSuchResourceException;
import edu.miu.productservice.model.Promotion;
import org.springframework.http.ResponseEntity;

public interface PromotionService {
	
	public Promotion addPromotion(Promotion promotion);
	public Promotion getPromotion(long promotionId) throws NoSuchResourceException;
	public List<Promotion> getAllPromotions();
	public Promotion updatePromotion(long promotionID, Promotion update_promotion);
	public Promotion deletePromotion(long promotionId) throws NoSuchResourceException;

	List<Promotion> getVendorPormotions(Long vendoId);;

	public List<Promotion> getDeletedPromotions();

	public List<Promotion> getNonDeletedPromotions();

	List<Promotion> getAllVendorValidPromotions(long vendorId);
}
