package edu.miu.productservice.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    private Long VendorId;
    private String imageUrl;
    private int stockAmount;
    private boolean isPublished;
    private int soldAmount;


    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Product(@Valid @NotNull Category category, String title, String description, double price, Date creationDate,
                   String attributes, String imageUrl, int stockAmount, boolean isPublished, int soldAmount, Long vendorId) {
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
        this.soldAmount = soldAmount;
        this.VendorId = vendorId;
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


    public int getSoldAmount() {
        return this.soldAmount;
    }

    public void setSoldAmount(int soldamount) {
        this.soldAmount = soldamount;
    }

	public Long getVendorId() {
		return VendorId;
	}

	public void setVendorId(Long vendorId) {
		VendorId = vendorId;
	}
}
