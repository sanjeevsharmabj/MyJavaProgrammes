package com.wellsfargo.fsd.jw3.service;

import com.wellsfargo.fsd.jw3.model.EmployeeModel;

public class EmployeeService {

	public void computeAll(EmployeeModel empmodel) {
		
		empmodel.setHra(empmodel.getBasic()*0.40);
		empmodel.setTa(empmodel.getBasic()*0.20);
		
	}
	
	
	
}
