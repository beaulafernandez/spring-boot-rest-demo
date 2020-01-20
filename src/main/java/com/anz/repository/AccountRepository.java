package com.anz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.model.Customer;
import com.anz.model.CustomerAccount;

@Repository
public interface AccountRepository extends JpaRepository<CustomerAccount, String>{

	public CustomerAccount findByAccountNo(String accountNo);
	public List<CustomerAccount> findByCustomer(Customer customer);
	public List<CustomerAccount> findByCustomer_CustomerId(String customerId);
}
