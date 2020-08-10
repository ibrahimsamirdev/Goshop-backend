package edu.miu.productservice.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    private String name;



	private  String description;

	private boolean isDeleted;
	
//	@OneToMany(cascade = {CascadeType.ALL})
//	private List<Category> subCategories;

	@ManyToOne
	@JoinColumn(name="category_id")
	private Category partentCaregory;


	public Category() {
	}


	public Category(String name, String description, boolean isDeleted, Category partentCaregory) {
		this.name = name;
		this.description = description;
		this.isDeleted = isDeleted;
		this.partentCaregory = partentCaregory;
	}
//	public Category(String name, String description, boolean isDeleted, List<Category> subCategories) {
//		this.name = name;
//		this.description = description;
//		this.isDeleted = isDeleted;
//		this.subCategories = subCategories;
//	}



	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(long id) {
		this.id = id;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

//	public List<Category> getSubCategories() {
//		return subCategories;
//	}
//
//	public void setSubCategories(List<Category> subCategories) {
//		this.subCategories = subCategories;
//	}


	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}

	public Category getPartentCaregory() {
		return partentCaregory;
	}

	public void setPartentCaregory(Category partentCaregory) {
		this.partentCaregory = partentCaregory;
	}
}
