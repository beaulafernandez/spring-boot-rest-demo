package com.anz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.model.CustomerAccount;
import com.anz.model.Transaction;
/**
 * This class uses the query creation mechanism 
 * from method names in spring data JPA to get data
 * from the Transaction table
 * @author beaula.fernandez
 *
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>{
	
	public Transaction findByTransactionId(long transactionId);
	public List<Transaction> findByCustomerAccount_AccountNo(String accountNo);
	public List<Transaction> findByCustomerAccount(CustomerAccount account);

}
