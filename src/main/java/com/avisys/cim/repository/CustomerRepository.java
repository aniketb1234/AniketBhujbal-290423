package com.avisys.cim.repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.avisys.cim.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// This method uses the @Query to create a custom query that finds the customers by their first name, last name and mobile number.
	 @Query("SELECT c FROM Customer c WHERE (:firstName IS NULL OR LOWER(c.firstName) LIKE %:firstName%) AND (:lastName IS NULL OR LOWER(c.lastName) LIKE %:lastName%) AND (:mobileNumber IS NULL OR c.mobileNumber = :mobileNumber)")
	   Optional<List<Customer>> findByFirstNameAndLastNameAndMobileNumber(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("mobileNumber") String mobileNumber);

	// This is a finder method which uses Spring Data JPA for finds the customers by their mobile number.
	// Spring Data JPA automatically generates a query that matches the method name and the parameter name to the database column names.
	Optional<List<Customer>> findByMobileNumber(String mobileNumber);
}
