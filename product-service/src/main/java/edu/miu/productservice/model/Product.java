package com.goshop.productservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId", nullable = false)
	@Valid
	@NotNull
	private Category category;
	
	private String title;
	private String description;
	private double price;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date creationDate;
	private String attributes;
	//vendor Id
	private String imageUrl;
	private int stockAmount;
	private boolean isPublished;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(@Valid @NotNull Category category, String title, String description, double price, Date creationDate,
			String attributes, String imageUrl, int stockAmount, boolean isPublished) {
		super();
		this.category = category;
		this.title = title;
		this.description = description;
		this.price = price;
		this.creationDate = creationDate;
		this.attributes = attributes;
		this.imageUrl = imageUrl;
		this.stockAmount = stockAmount;
		this.isPublished = isPublished;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}

	public boolean isPublished() {
		return isPublished;
	}

	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}
	
	
	
	
	
	
	
	
	
	

}
