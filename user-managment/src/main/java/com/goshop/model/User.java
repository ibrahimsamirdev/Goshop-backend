package com.goshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	@Column(unique = true, length = 250)
	private String email;
	private String pass;
	private String mobile;
	private Boolean isSubscribed;
//	@OneToMany(mappedBy = "user")
//	private Set<Address> addresses;
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Boolean getSubscribed() {
		return isSubscribed;
	}

	public void setSubscribed(Boolean subscribed) {
		isSubscribed = subscribed;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
