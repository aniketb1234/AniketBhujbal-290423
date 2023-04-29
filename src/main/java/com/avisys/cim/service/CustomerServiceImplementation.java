package com.avisys.cim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.avisys.cim.Customer;
import com.avisys.cim.repository.CustomerRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImplementation implements CustomerService{

	@Autowired
	private CustomerRepository customerRepoistory; // autowiring the CustomerRepository interface .
	
	// This method get all customers from the database using the `customerRepoistory.findAll()` method which is provided by Spring Data JPA.
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list=customerRepoistory.findAll();
		return list;
	}
	// This method searches for customers in the database by their first name, last name, and mobile number using the `customerRepoistory.findByFirstNameAndLastNameAndMobileNumber()` method provided by Spring Data JPA.
	// If the method does not find any matching customers, it throws an exception using the `orElseThrow()` method.
	@Override
	public List<Customer> getByFirstNameAndLastNameAndMobileNumber(String firstName, String lastName,
			String mobileNumber) {
		return customerRepoistory.findByFirstNameAndLastNameAndMobileNumber(firstName, lastName, mobileNumber).orElseThrow();
		
	}

	// This method creates a new customer to the database using the method "save" provided by Spring Data JPA.
	@Override
	public void createCustomer(Customer customer) {
		System.out.println(customer.toString()+"inservice"+customer.getId());
		 customerRepoistory.save(customer);
	}

}
