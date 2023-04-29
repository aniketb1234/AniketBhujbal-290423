package com.avisys.cim.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.avisys.cim.Customer;
import com.avisys.cim.dto.CreateCustomerRequest;
import com.avisys.cim.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService; // autowiring the CustomerService interface .
	
	// Returns all the customers from database using JpaRepository  inbuilt  findAll method
	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> getAll() {
		List<Customer> list= customerService.getAllCustomers();
		return ResponseEntity.ok(list);
	}
	
	//**this method deletes the customer by using mobile number.
	@DeleteMapping("/deleteByMobileno")
	public ResponseEntity<?> deleteByMobileNo(@RequestParam("mobileno") String mobileno) {
		return ResponseEntity.ok(customerService.deleteCustomerByMobileNo(mobileno));
	}
	

	
	
    //*** Creates a new customer in the database.
	//here "CreateCustomerRequest" it is DTO which binds the request object
    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody CreateCustomerRequest customer) {
       customerService.createCustomer(customer);
        return ResponseEntity.ok("Customer created successfully.");
    }
}
