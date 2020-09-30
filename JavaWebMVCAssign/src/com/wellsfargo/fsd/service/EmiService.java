package com.wellsfargo.fsd.service;

import com.wellsfargo.fsd.model.EmiModel;

public class EmiService {
	
	public void computeEMI(EmiModel emimodel) {
		
		double ptr = ((emimodel.getPrincipal())*(emimodel.getDuration())*(emimodel.getRoi()));
		emimodel.setEmiamount(ptr/100);
	}

}
