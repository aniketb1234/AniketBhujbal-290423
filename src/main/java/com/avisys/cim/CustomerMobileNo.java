package com.avisys.cim;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "Customer_Mobile_Numbers")
public class CustomerMobileNo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @JsonIgnore
	private Long id;

	@Column(name = "Mobile_Number", nullable = false,unique = true)
	private String mobileNumber;

	@ManyToOne
    @JoinColumn(name = "customer_Id")
    @JsonIgnore
    private Customer customer;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public CustomerMobileNo(String mobileNumber, Customer customer) {
		
		this.mobileNumber = mobileNumber;
		this.customer = customer;
	}
	



	public CustomerMobileNo() {
		
	}

}
