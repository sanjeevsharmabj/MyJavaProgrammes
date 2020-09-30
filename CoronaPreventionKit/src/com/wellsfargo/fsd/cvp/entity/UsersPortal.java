package com.wellsfargo.fsd.cvp.entity;

public class UsersPortal {
	
	
	private String newUser;
	private String firstName;
	private String lastName;
	private String address;
	private String emailAdd;
	private String contactNo;
	
	public UsersPortal() {
		
	}
	
	public UsersPortal(String newUser, String firstName,
			String lastName, String address, String emailAdd, String contactNo) {
		super();
		
		this.newUser = newUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailAdd = emailAdd;
		this.contactNo = contactNo;
	}
	
	public String getNewUser() {
		return newUser;
	}
	public void setNewUser(String newUser) {
		this.newUser = newUser;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailAdd() {
		return emailAdd;
	}
	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "UsersPortal [ newUser="+ newUser + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", emailAdd=" + emailAdd + ", contactNo=" + contactNo + "]";
	}
	
	
}
