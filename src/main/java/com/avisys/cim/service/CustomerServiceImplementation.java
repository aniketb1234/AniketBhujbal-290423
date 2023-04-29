package com.avisys.cim.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.avisys.cim.Customer;
import com.avisys.cim.CustomerMobileNo;
import com.avisys.cim.dto.CreateCustomerRequest;
import com.avisys.cim.repository.CustomerMobileNumberRepository;
import com.avisys.cim.repository.CustomerRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImplementation implements CustomerService{

	@Autowired
	private CustomerRepository customerRepoistory; // autowiring the CustomerRepository interface .
	
	
	@Autowired
	private CustomerMobileNumberRepository customerMobileNumberRepository; // autowiring the CustomerMobileNumberRepository interface .
	
	// This method get all customers from the database using the `customerRepoistory.findAll()` method which is provided by Spring Data JPA.
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list=customerRepoistory.findAll();
		list.forEach(x->x.getMobileNumbers().toString());
		return list;
	}

	
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

	//**this method deletes the customer for that mobile no
	//get the object of CustomerMobileNo by method findbyMobileNumber then delete by the id by extracting customerId from the "CustomerMobileNo"
	//and finally returns the success message.
	@Override
	public String deleteCustomerByMobileNo(String mobileno) {
		CustomerMobileNo customerMobileNo= customerMobileNumberRepository.findByMobileNumber(mobileno);
		customerRepoistory.deleteById(customerMobileNo.getCustomer().getId());
		return "Deleted Successfully...!!!";
	}

}
