package com.anz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anz.model.CustomerAccount;
import com.anz.model.Transaction;
import com.anz.repository.AccountRepository;
import com.anz.repository.TransactionRepository;

@Component
public class AccountServiceImpl implements AccountService{
	
	@Autowired 
	private AccountRepository accountRepo;
	
	@Autowired 
	private TransactionRepository transactionRepo;

	@Override
	public List<CustomerAccount> retrieveCustomerDetails(String customerId) {
		return accountRepo.findByCustomer_CustomerId(customerId);
	}

	@Override
	public List<Transaction> retrieveAccountTransactions(String accountNo) {
		CustomerAccount account = accountRepo.findByAccountNo(accountNo);
		return transactionRepo.findByCustomerAccount(account);
	}

	

}
