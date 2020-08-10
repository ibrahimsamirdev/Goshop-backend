package edu.miu.productservice.model;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "category_id")
//	@Valid
//	@NotNull
	private Category category;

	private String title;
	private String description;
	private double price;

//	@Temporal(TemporalType.DATE)
//	@NotNull
	private LocalDate creationDate;
	private String attributes;
	private long vendorId;
	private String imageUrl;
	private long stockAmount;
	//for Order
	private long soldAmount;
	private boolean isPublished = false;
	private boolean isDeleted= false;

	@ManyToMany
	@JoinTable
	private List<Promotion> promotions;

	public Product() {
		super();
		this.creationDate = LocalDate.now();
		// TODO Auto-generated constructor stub
	}



	public Product( Category category, String title, String description, double price, LocalDate creationDate,
				   String attributes, String imageUrl, long stockAmount, boolean isPublished, boolean isDeleted, List<Promotion> promotions) {
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
		this.isDeleted = isDeleted;
		this.promotions = promotions;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public long getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(long stockAmount) {
		this.stockAmount = stockAmount;
	}

	public long getSoldAmount() {
		return soldAmount;
	}

	public void setSoldAmount(long soldAmount) {
		this.soldAmount = soldAmount;
	}

	public boolean isPublished() {
		return isPublished;
	}

	public void setPublished(boolean published) {
		isPublished = published;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}
}
