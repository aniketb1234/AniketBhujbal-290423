package com.avisys.cim.service;

import java.util.List;

import com.avisys.cim.Customer;
import com.avisys.cim.dto.CreateCustomerRequest;
import com.avisys.cim.dto.UpdateMobilenoRequest;

public interface CustomerService {

	List<Customer> getAllCustomers();
	


	void createCustomer(CreateCustomerRequest customer);



	String deleteCustomerByMobileNo(String mobileno);



	String UpdateCustomerMobileno(String existing,String New);


}
