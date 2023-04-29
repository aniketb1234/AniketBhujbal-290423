package com.avisys.cim.dto;

import java.util.List;

public class CreateCustomerRequest {

	
	private String firstName;

	
	private String lastName;
	
	   
	    private List<String> mobileNumbers ;


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


		public List<String> getMobileNumbers() {
			return mobileNumbers;
		}


		public void setMobileNumbers(List<String> mobileNumbers) {
			this.mobileNumbers = mobileNumbers;
		}

	    
}
