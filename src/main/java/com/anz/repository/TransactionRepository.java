package com.anz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.model.CustomerAccount;
import com.anz.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>{
	
	public List<Transaction> findByCustomerAccount_AccountNo(String accountNo);
	public List<Transaction> findByCustomerAccount(CustomerAccount account);

}
