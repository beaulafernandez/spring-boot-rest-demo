package com.anz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class CustomerController {	
	
	@Autowired 
	private AccountService accountService;
	
	@RequestMapping(value = "/customer/accounts/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<CustomerAccount>> viewCustomerAccounts(@PathVariable String customerId){	
		List<CustomerAccount> accounts =  accountService.retrieveCustomerDetails(customerId);		
		return ResponseEntity.ok().body(accounts);	
	}
	
	@RequestMapping(value = "/account/transactions/{accountNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Transaction>> viewAccountTransactions(@PathVariable String accountNo){
		List<Transaction> transactions =  accountService.retrieveAccountTransactions(String.valueOf(accountNo.trim()));	
		return ResponseEntity.ok().body(transactions);		
	}
}
