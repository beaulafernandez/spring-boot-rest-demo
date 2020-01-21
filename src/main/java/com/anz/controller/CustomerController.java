package com.anz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anz.model.CustomerAccount;
import com.anz.model.Transaction;
import com.anz.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provide functionalities for 
 * getting customer's account and transaction details
 * @author beaula.fernandez
 *
 */
@RestController
public class CustomerController {	
	
	@Autowired 
	private AccountService accountService;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	/**
	 * This method is used to retrieve customer account details
	 * based on the customer id passed in the request
	 * @param customerId the id of the customer
	 * @return list of customer accounts
	 */
	@RequestMapping(value = "/customer/accounts/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<CustomerAccount>> viewCustomerAccounts(@PathVariable String customerId){			
		logger.info("GET Request for customer account [ " + customerId +" ]");
		List<CustomerAccount> accounts =  accountService.retrieveCustomerDetails(customerId);
		if(accounts.isEmpty()){
			logger.error("Customer ["+ customerId +"] has no accounts" );
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.ok().body(accounts);	
	}
	
	/**
	 * This method if used to retreive the transactions of an account
	 * based on the account number passed in the request
	 * @param accountNo the accountNo of the customer
	 * @return list of transactions
	 */
	@RequestMapping(value = "/account/transactions/{accountNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Transaction>> viewAccountTransactions(@PathVariable String accountNo){
		logger.info("GET Request for transactions for account : " + accountNo);
		List<Transaction> transactions =  accountService.retrieveAccountTransactions(String.valueOf(accountNo.trim()));	
		if(transactions.isEmpty()){
			logger.error("No transaction for the account number ["+ accountNo +"]" );
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.ok().body(transactions);		
	}
}
