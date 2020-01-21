package com.anz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anz.model.Customer;

/**
 * This class uses the query creation mechanism 
 * from method names in spring data JPA to get data
 * from the Customer table
 * @author beaula.fernandez
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, String>{
	
	public Customer findByCustomerId(String customerId);

}
