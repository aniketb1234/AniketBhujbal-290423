package com.avisys.cim.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.avisys.cim.Customer;
import com.avisys.cim.CustomerMobileNo;
import com.avisys.cim.dto.CreateCustomerRequest;
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
		list.forEach(x->x.getMobileNumbers().toString());
		return list;
	}
	//***due to change in Customer entity this cannot work in this Requirements but we are using it in future. 
	// This method searches for customers in the database by their first name, last name, and mobile number using the `customerRepoistory.findByFirstNameAndLastNameAndMobileNumber()` method provided by Spring Data JPA.
	// If the method does not find any matching customers, it throws an exception using the `orElseThrow()` method.
//	@Override
//	public List<Customer> getByFirstNameAndLastNameAndMobileNumber(String firstName, String lastName,
//			String mobileNumber) {
//		return customerRepoistory.findByFirstNameAndLastNameAndMobileNumber(firstName, lastName, mobileNumber).orElseThrow();
//		
//	}
	
	
	//*** This method creates a new customer and CustomerMobileNos to the database using the method "save" provided by Spring Data JPA.
	//one customer can have multiple mobile no objects
	//if Mobile Number already present in database it violets the unique constraint in the "CustomerMobileNo" class which 
	// throws exception "JdbcSQLIntegrityConstraintViolationException" which is catch in global exception handler class in the exception package.
	@Override
	public void createCustomer(CreateCustomerRequest customer) {
		
		Customer cust=new Customer();
		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		
		List<CustomerMobileNo> mobileNumbers = new ArrayList<>();
		
		for (String str : customer.getMobileNumbers()) {
			CustomerMobileNo customermobileno=new CustomerMobileNo(str,cust);
			mobileNumbers.add(customermobileno);
		
		}
		cust.setMobileNumbers(mobileNumbers);
		customerRepoistory.save(cust);
	}

}
