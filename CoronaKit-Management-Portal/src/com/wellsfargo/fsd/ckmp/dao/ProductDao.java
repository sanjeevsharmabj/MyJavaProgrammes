package com.wellsfargo.fsd.ckmp.dao;

import java.util.List;

import com.wellsfargo.fsd.ckmp.entity.Product;
import com.wellsfargo.fsd.ckmp.exception.CoronaKitException;

public interface ProductDao {
	
	Product add(Product product) throws CoronaKitException;
	Product save(Product product) throws CoronaKitException;
	boolean deleteById(Integer productId) throws CoronaKitException;
	List<Product> getAll() throws CoronaKitException;
	Product getById(Integer productId) throws CoronaKitException;
	
}
