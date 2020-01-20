package com.anz.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable{	
	
	private static final long serialVersionUID = -3339659644107093123L;

	@Id
	@Column(name = "customerId")
	private String customerId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phoneNumber", length=10)
	private int phoneNumber;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<CustomerAccount> accounts;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<CustomerAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<CustomerAccount> accounts) {
		this.accounts = accounts;
	}
	
		
	
}
