package edu.miu.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.miu.productservice.model.Promotion;
import edu.miu.productservice.service.PromotionService;

@RestController
@RequestMapping("/promotion")
@CrossOrigin("*")
public class PromotionController {
	
	@Autowired
	PromotionService promotionService;
	
	@PostMapping(value="/")
	public ResponseEntity<Promotion> addPromotion( @RequestBody Promotion promotion){
		HttpHeaders headers = new HttpHeaders();
		
		if (promotion == null) {
			return new ResponseEntity<Promotion>(HttpStatus.BAD_REQUEST);
		}
		
		promotionService.addPromotion(promotion);
		
		return new ResponseEntity<Promotion>(promotion, headers,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Promotion>> getPromotions(){
		
		HttpHeaders headers = new HttpHeaders();

		List<Promotion> promotions = promotionService.getPromotions();

		if (promotions == null) {
			return new ResponseEntity<List<Promotion>>(HttpStatus.NOT_FOUND);
		}
		headers.add("Number of Blocks returned", String.valueOf(promotions.size()));

		return new ResponseEntity<List<Promotion>>(promotions, headers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{promotionId}")
	public ResponseEntity<Promotion> getPromotion(@PathVariable long promotionId) {

		Promotion promotion = promotionService.getPromotion(promotionId);

		if (promotion == null) {

			return new ResponseEntity<Promotion>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Promotion>(promotion, HttpStatus.OK);
	}
	
	
	@PutMapping(value="/{promotionId}")
	public ResponseEntity<Promotion> updatePromotion(@PathVariable long promotionId,@RequestBody Promotion promotion){
		
		HttpHeaders headers = new HttpHeaders();
		Promotion promotion_toEdit = promotionService.getPromotion(promotionId);
		
		if(promotion_toEdit == null) {
			
			return new ResponseEntity<Promotion>(HttpStatus.NOT_FOUND);
		}
		
		promotionService.updatePromotion(promotionId, promotion);
		
		headers.add("Updated Block : ",String.valueOf(promotionId));
		
		return new ResponseEntity<Promotion>(promotion,headers, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/{promotionId}")
	public Promotion deletePromotion(@PathVariable long promotionId){

		return  promotionService.deletePromotion(promotionId);
	}

}
