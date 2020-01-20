package com.anz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anz.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	
	public Customer findByCustomerId(String customerId);

}
