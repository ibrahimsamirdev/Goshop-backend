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

	private String  title;
	private Date startDate;
	private Date endDate;
	private double discount;
	private boolean isDeleted;



	//vendor id;
	public Promotion() {
		super();

	}

	public Promotion(String title, Date startDate, Date endDate, double discount) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.discount = discount;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}


}
