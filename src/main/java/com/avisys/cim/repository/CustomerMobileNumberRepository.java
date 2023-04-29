package com.avisys.cim.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.avisys.cim.Customer;
import com.avisys.cim.CustomerMobileNo;

public interface CustomerMobileNumberRepository extends JpaRepository<CustomerMobileNo, Long> {

	//this is finder method which uses mobile no to find the CustomerMobileNo object 
	//spring data JPA creates the query for this method
	CustomerMobileNo findByMobileNumber(String mobileno);

}
