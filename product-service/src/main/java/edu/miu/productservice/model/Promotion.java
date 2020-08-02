package edu.miu.productservice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Promotion {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToMany
	@JoinTable(name="promotion_product")
	private List<Product> product;
	
	private String  title;
	private Date startDate;
	private Date endDate;
	private double discount;
	//vendor id;
	public Promotion() {
		super();
		
	}
	
	public Promotion(List<Product> product, String title, Date startDate, Date endDate, double discount) {
		super();
		this.product = product;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.discount = discount;
	}


	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	

	
	
}
