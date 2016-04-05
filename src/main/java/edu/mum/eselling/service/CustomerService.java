package edu.mum.eselling.service;

import edu.mum.eselling.domain.Customer;

public interface CustomerService {

	void addNewCustomer(Customer customer);

	public Customer getCustomerByUserName(String name);

}
