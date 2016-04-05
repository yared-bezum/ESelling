package edu.mum.eselling.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import org.springframework.data.repository.query.Param;

import edu.mum.eselling.domain.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	
	@Query("SELECT c FROM Customer c WHERE c.credentials.username = :name")
	public Customer findCustomerByUserName(
			@Param(value = "name") String name);

}
