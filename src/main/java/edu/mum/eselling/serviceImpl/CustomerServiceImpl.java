package edu.mum.eselling.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eselling.domain.Customer;
import edu.mum.eselling.repository.CredentialRepository;
import edu.mum.eselling.repository.CustomerRepository;
import edu.mum.eselling.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CredentialRepository credentialRepository;

	public void addNewCustomer(Customer customer) {
		credentialRepository.save(customer.getCredentials());
		customerRepository.save(customer);
	}

	public Customer getCustomerByUserName(String name) {

		return customerRepository.findCustomerByUserName(name);
	}

}
