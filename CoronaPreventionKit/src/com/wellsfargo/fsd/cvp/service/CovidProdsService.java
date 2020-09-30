package com.wellsfargo.fsd.cvp.service;

import java.util.List;

import com.wellsfargo.fsd.cvp.entity.CovidProds;
import com.wellsfargo.fsd.cvp.exception.CovidProdException;

public interface CovidProdsService {
	
	CovidProds ValidateandAdd(CovidProds covidprods) throws CovidProdException;
	CovidProds ValidateandSave(CovidProds covidprods) throws CovidProdException;
	
	boolean deletCovidProds(int prodId) throws CovidProdException;
	CovidProds getCovidProds(int prodId) throws CovidProdException;
	List<CovidProds> getAllCovidProds() throws CovidProdException;
	
	

}
