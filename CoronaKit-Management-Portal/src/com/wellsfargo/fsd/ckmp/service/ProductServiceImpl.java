package com.wellsfargo.fsd.ckmp.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.ckmp.dao.ProductDao;
import com.wellsfargo.fsd.ckmp.dao.ProductDaoJdbcImpl;
import com.wellsfargo.fsd.ckmp.entity.Product;
import com.wellsfargo.fsd.ckmp.exception.CoronaKitException;

public class ProductServiceImpl implements ProductService {
	
	ProductDao productDao;
	
	public ProductServiceImpl() {
		productDao = new ProductDaoJdbcImpl();
	}

	private boolean isValidProductId(Integer productId) {
		return productId!=null && productId>0;
	}
	
	private boolean isValidProductName(String productName) {
		return productName!=null && productName.length()<30;
	}
	
	private boolean isValidProductCost(Double productCost) {
		return productCost!=null && productCost>0;
	}
	
	private boolean isValidProductDesc(String productDesc) {
		return productDesc.length()<100;
	}
	
	private boolean isValidProduct(Product product) throws CoronaKitException{
		boolean isValid=true;
		
		List<String> errMsgs = new ArrayList<>();
		
		if(product!=null) {
			if(!isValidProductId(product.getProductId())) {
				isValid=false;
				errMsgs.add("Product Id must be a positive non-repetative number");
			}
			if(!isValidProductName(product.getProductName())) {
				isValid=false;
				errMsgs.add("Product name must be less than 30 chars in length");
			}
			if(!isValidProductCost(product.getProductCost())) {
				isValid=false;
				errMsgs.add("Product cost must be a postive non-zero number");
			}
			if(!isValidProductDesc(product.getProductDesc())) {
				isValid=false;
				errMsgs.add("Product description must be less than 100 chars in length");
			}
			if(!errMsgs.isEmpty()) {
				throw new CoronaKitException(errMsgs.toString());
			}
		}else {
			isValid=false;
		}
		
		return isValid;
	}
	
	
	@Override
	public Product validateAndAdd(Product product) throws CoronaKitException {
		if(isValidProduct(product)) {
			productDao.add(product);
		}
		return product;
	}

	@Override
	public Product validateAndSave(Product product) throws CoronaKitException {
		if(isValidProduct(product)) {
			productDao.save(product);
		}
		return product;
	}

	@Override
	public boolean deleteProduct(Integer productId) throws CoronaKitException {
		return productDao.deleteById(productId);
	}

	@Override
	public Product getProduct(Integer productId) throws CoronaKitException {
		return productDao.getById(productId);
	}

	@Override
	public List<Product> getAllProducts() throws CoronaKitException {
		return productDao.getAll();
	}

}
