package com.avisys.cim.service;

import java.util.List;

import com.avisys.cim.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();
	
	//***due to change in Customer entity this cannot work in this Requirements but we are using it in future. 
//	List<Customer> getByFirstNameAndLastNameAndMobileNumber(String firstName, String lastName, String mobileNumber);


	void createCustomer(Customer customer);


}
