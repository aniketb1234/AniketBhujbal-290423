package com.avisys.cim.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.avisys.cim.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
