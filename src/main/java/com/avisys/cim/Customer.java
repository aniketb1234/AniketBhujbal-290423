package com.avisys.cim;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customer_Id", updatable = false, nullable = false)
	private Long customerId;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

//	@Column(name = "MOBILE_NUMBER", unique = true, nullable = false)
//	private String mobileNumber;
	
	   @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    private List<CustomerMobileNo> mobileNumbers = new ArrayList<>();

	public Long getId() {
		return customerId;
	}
	

	public void setId(Long id) {
		this.customerId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public List<CustomerMobileNo> getMobileNumbers() {
		return mobileNumbers;
	}


	public void setMobileNumbers(List<CustomerMobileNo> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}


	@Override
	public String toString() {
		return "Customer [id=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumbers="
				+ mobileNumbers + "]";
	}

//	public String getMobileNumber() {
//		return mobileNumber;
//	}
//
//	public void setMobileNumber(String mobileNumber) {
//		this.mobileNumber = mobileNumber;
//	}
	

//	@Override
//	public String toString() {
//		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
//				+ mobileNumber + "]";
//	}
	



}
