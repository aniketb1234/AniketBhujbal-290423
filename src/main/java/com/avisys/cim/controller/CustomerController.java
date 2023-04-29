package com.avisys.cim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.service.CustomerService;


@RestController
@RequestMapping("/customer")
@CrossOrigin()
public class CustomerController {

	@Autowired
	private CustomerService customerService; 
	
	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> getAll() {
		List<Customer> list= customerService.getAllCustomers();
		return ResponseEntity.ok(list);
	}

    @GetMapping("/get")
    public ResponseEntity<List<Customer>> getCustomers(@RequestParam(required = false) String firstName,
                                        @RequestParam(required = false) String lastName,
                                        @RequestParam(required = false) String mobileNumber) {

    	 List<Customer>	list= customerService.getByFirstNameAndLastNameAndMobileNumber(firstName, lastName, mobileNumber);
    	
    	return ResponseEntity.ok(list);
    }
}
