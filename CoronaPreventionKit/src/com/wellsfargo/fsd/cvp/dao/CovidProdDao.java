package com.wellsfargo.fsd.cvp.dao;

import java.util.List;

import com.wellsfargo.fsd.cvp.entity.CovidProds;
import com.wellsfargo.fsd.cvp.exception.CovidProdException;

public interface CovidProdDao {
	
	CovidProds add(CovidProds covidprods) throws CovidProdException;
	CovidProds save(CovidProds covidprods) throws CovidProdException;
	boolean deletebyId(int prodId) throws CovidProdException;
	
	List<CovidProds> getAll() throws CovidProdException;
	CovidProds getById(int prodId) throws CovidProdException;

}
