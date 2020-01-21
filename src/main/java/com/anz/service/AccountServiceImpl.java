package com.anz.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anz.model.CustomerAccount;
import com.anz.model.Transaction;
import com.anz.repository.AccountRepository;
import com.anz.repository.TransactionRepository;

/**
 * Implementaion for the interface AccountService
 * This class is used to define the methods provided in 
 * the interface. Interaction with the database to pull data
 * and expose it in API
 * @author beaula.fernandez
 *
 */
@Component
public class AccountServiceImpl implements AccountService{
	
	@Autowired 
	private AccountRepository accountRepo;
	
	@Autowired 
	private TransactionRepository transactionRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	/**
    * Gets the customer account
    * @param customerId the customer id
    * @throws Exception
    */
	@Override
	public List<CustomerAccount> retrieveCustomerDetails(String customerId) {
		logger.info("Retrieve account details from the database for customer id : " + customerId);
		return accountRepo.findByCustomer_CustomerId(customerId);
	}

	/**
    * Gets the account transactions
    * @param accountNo the account number
    * @throws Exception
    */
	@Override
	public List<Transaction> retrieveAccountTransactions(String accountNo) {
		logger.info("Retrieve transactions from the database for customer account : " + accountNo);
		CustomerAccount account = accountRepo.findByAccountNo(accountNo);
		return transactionRepo.findByCustomerAccount(account);
	}

}
