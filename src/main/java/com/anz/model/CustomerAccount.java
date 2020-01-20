package com.anz.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer_account")
public class CustomerAccount implements Serializable{	
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "accountNo")	
	private String accountNo;
	
	@Column(name = "accountName")	
	private String accountName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="accountType", length=250, nullable=false, unique=false)
	private AccountType accountType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "currency")	
	private Currency currency; 
	
	@Column(name = "balanceDate")	
	private Date balanceDate;
	
	@Column(name = "balanceAmount")	
	private BigDecimal balanceAmount;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
	private Customer customer;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerAccount")
	private List<Transaction> transactions;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
}
