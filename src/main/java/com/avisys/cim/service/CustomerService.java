package com.avisys.cim.service;

import java.util.List;

import com.avisys.cim.Customer;
import com.avisys.cim.dto.CreateCustomerRequest;

public interface CustomerService {

	List<Customer> getAllCustomers();
	


	void createCustomer(CreateCustomerRequest customer);



	String deleteCustomerByMobileNo(String mobileno);


}
