package com.wellsfargo.fsd.ckmp.service;

import java.util.List;

import com.wellsfargo.fsd.ckmp.entity.Product;
import com.wellsfargo.fsd.ckmp.exception.CoronaKitException;

public interface ProductService {
	
	Product validateAndAdd(Product product) throws CoronaKitException;
	Product validateAndSave(Product product) throws CoronaKitException;
	boolean deleteProduct(Integer productId) throws CoronaKitException;
	Product getProduct(Integer productId) throws CoronaKitException;
	List<Product> getAllProducts() throws CoronaKitException;

}
