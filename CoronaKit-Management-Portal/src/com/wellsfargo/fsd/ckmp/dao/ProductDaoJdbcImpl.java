package com.wellsfargo.fsd.ckmp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.ckmp.entity.Product;
import com.wellsfargo.fsd.ckmp.exception.CoronaKitException;

public class ProductDaoJdbcImpl implements ProductDao {

	public static final String INS_PT_QRY = "INSERT INTO products(pid,pname,pcost,pdesc) VALUES(?,?,?,?)";
	public static final String UPD_PT_QRY = "UPDATE products SET pname=?,pcost=?,pdesc=? WHERE pid=?";
	public static final String DEL_PT_QRY = "DELETE FROM products WHERE pid=?";
	public static final String GET_BY_ID_PT_QRY = "SELECT pid,pname,pcost,pdesc FROM products WHERE pid=?";
	public static final String GET_ALL_PTS_QRY = "SELECT pid,pname,pcost,pdesc FROM products";
	
	
	@Override
	public Product add(Product product) throws CoronaKitException {
		if (product != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_PT_QRY);) {

				pst.setInt(1, product.getProductId());
				pst.setString(2, product.getProductName());
				pst.setDouble(3, product.getProductCost());
				pst.setString(4, product.getProductDesc());
				
				pst.executeUpdate();

			} catch (SQLException exp) {
				throw new CoronaKitException("An error occured, Could not add the product details!");
			}
		}
		return product;
	}

	@Override
	public Product save(Product product) throws CoronaKitException {
		if (product != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_PT_QRY);) {

				pst.setString(1, product.getProductName());
				pst.setDouble(2, product.getProductCost());
				pst.setString(3, product.getProductDesc());
				pst.setInt(4, product.getProductId());
				
				pst.executeUpdate();

			} catch (SQLException exp) {
				throw new CoronaKitException("An error occured, Could not save the product details!");
			}
		}
		return product;
	}

	@Override
	public boolean deleteById(Integer productId) throws CoronaKitException {
		boolean isDeleted = false;

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_PT_QRY);) {

			pst.setInt(1, productId);

			int rowsCount = pst.executeUpdate();
			
			isDeleted= rowsCount>0 ;

		} catch (SQLException exp) {
			throw new CoronaKitException("An error occured, Could not delete the product details!");
		}

		return isDeleted;
	}

	@Override
	public List<Product> getAll() throws CoronaKitException {
		List<Product> products = new ArrayList<>();
		
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_ALL_PTS_QRY);) {		

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductCost(rs.getDouble(3));
				product.setProductDesc(rs.getString(4));
				
				products.add(product);
			}
			
			if(products.isEmpty()) {
				products=null;
			}
			
		} catch (SQLException exp) {
			throw new CoronaKitException("An error occured, Could not retrive the product details!");
		}
				
		return products;
	}

	@Override
	public Product getById(Integer productId) throws CoronaKitException {
		Product product = null;
		
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_BY_ID_PT_QRY);) {		

			pst.setInt(1, productId);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductCost(rs.getDouble(3));
				product.setProductDesc(rs.getString(4));
			}
			
		} catch (SQLException exp) {
			throw new CoronaKitException("An error occured, Could not retrive the product details!");
		}
				
		return product;
	}
	

}
