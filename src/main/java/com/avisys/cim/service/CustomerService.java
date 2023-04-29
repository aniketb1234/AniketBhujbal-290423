package com.avisys.cim.service;

import java.util.List;

import com.avisys.cim.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();

	List<Customer> getByFirstNameAndLastNameAndMobileNumber(String firstName, String lastName, String mobileNumber);


}
