package com.goshop.productservice.bean;

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
	@JoinColumn(name = "courseId", nullable = false)
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
	
	
	
	
	
	
	
	

}
