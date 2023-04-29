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
	private CustomerRepository customerRepoistory;
	
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list=customerRepoistory.findAll();
		return list;
	}

	@Override
	public List<Customer> getByFirstNameAndLastNameAndMobileNumber(String firstName, String lastName,
			String mobileNumber) {
		return customerRepoistory.findByFirstNameAndLastNameAndMobileNumber(firstName, lastName, mobileNumber).orElseThrow();
		
	}

}
