package com.muitodinheiro.app.services;

import org.springframework.stereotype.Service;

import com.muitodinheiro.app.dto.CustomerPostRequestBody;
import com.muitodinheiro.app.entities.Customer;
import com.muitodinheiro.app.repositories.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	
	private CustomerRepository customerRepository;
	
	public CustomerPostRequestBody save(CustomerPostRequestBody customerPostRequestBody) {
		Customer customer = new Customer();
		customer.setName(customerPostRequestBody.getName());
		customerRepository.save(customer);
		return customerPostRequestBody;
	}
}
