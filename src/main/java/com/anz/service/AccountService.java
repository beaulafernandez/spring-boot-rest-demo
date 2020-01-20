package com.anz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anz.model.CustomerAccount;
import com.anz.model.Transaction;

@Service
public interface AccountService {
	
	public List<CustomerAccount> retrieveCustomerDetails(String customerId);
	public List<Transaction> retrieveAccountTransactions(String accountNo);

}
