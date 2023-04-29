package com.avisys.cim.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
		System.out.println("inside controller");
		List<Customer> list= customerService.getAllCustomers();
		return ResponseEntity.ok(list);
	}
	
	//***due to change in Customer entity this cannot work in this Requirements but we are using it in future. 
	// Returns a list of customers filtered by the given first name, last name, and mobile number.
//    @GetMapping("/get")
//    public ResponseEntity<List<Customer>> getCustomers(@RequestParam(required = false) String firstName,
//                                        @RequestParam(required = false) String lastName,
//                                        @RequestParam(required = false) String mobileNumber) {
//
//    	 List<Customer>	list= customerService.getByFirstNameAndLastNameAndMobileNumber(firstName, lastName, mobileNumber);
//    	
//    	return ResponseEntity.ok(list);
//    }
//    

	
	
    //*** Creates a new customer in the database.
	//here "CreateCustomerRequest" it is DTO which binds the request object
    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody CreateCustomerRequest customer) {
       customerService.createCustomer(customer);
        return ResponseEntity.ok("Customer created successfully.");
    }
}
