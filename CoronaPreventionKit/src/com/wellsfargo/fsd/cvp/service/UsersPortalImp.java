package com.wellsfargo.fsd.cvp.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.cvp.entity.UsersPortal;
import com.wellsfargo.fsd.cvp.exception.CovidProdException;

public class UsersPortalImp {
	
	UsersPortal usersportal;

	private boolean isvalidFirstName(String firstName) {
		return firstName!=null && firstName.length()>0;
	}
	
	/*private boolean isvalidlastName(String lastName) {
		return lastName.length()>0;
	}*/
	
	private boolean isvalidaddress(String address) {
		return address!=null &&  address.length()>10 || address.length()<50;
	}
	
	private boolean isvalidContactNo(String contactNo) {
		return contactNo!=null && contactNo.length()==10;
	}
	
	private boolean isValidEmailAdd(String emailAdd) {
		return emailAdd.contains("@");
	}
	
	private boolean isValidUser(UsersPortal usersportal) throws CovidProdException {
		boolean isValid = true;
		List<String> errMsgs  = new ArrayList<>();
		if(usersportal!=null) {
			if(!isvalidFirstName(usersportal.getFirstName())) {
				isValid = false;
				errMsgs.add("First Name should not be null and FirstName must have atleast one character");
			}
			if(!isvalidaddress(usersportal.getAddress())) {
				isValid = false;
				errMsgs.add("Address must of be atleast 10 to 50 characters in length");
			}
			
			if(!isvalidContactNo(usersportal.getContactNo())) {
				isValid = false;
				errMsgs.add("Contact number must of be exactly 10 digits in length");
			}
			
			if(!isValidEmailAdd(usersportal.getEmailAdd())) {
				isValid = false;
				errMsgs.add("Email address should be in the format xxxx@xxx.*");
			}
			else
				isValid=false;
		}
		
		return isValid;
	}
	

}
