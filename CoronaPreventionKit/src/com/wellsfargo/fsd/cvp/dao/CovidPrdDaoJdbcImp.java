package com.wellsfargo.fsd.cvp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.cvp.entity.CovidProds;
import com.wellsfargo.fsd.cvp.exception.CovidProdException;

public class CovidPrdDaoJdbcImp implements CovidProdDao {

	public static final String INS_CP_QRY = "INSERT INTO covidprodts(productId,prodName,description,price) VALUES(?,?,?,?)";
	public static final String UPD_CP_QRY = "UPDATE covidprodts SET prodName=?,description=?,price=? WHERE productId=?";
	public static final String DEl_CP_QRY = "DELETE FROM covidprodts WHERE productId=?";
	public static final String GET_BY_ID_CP_QRY = "SELECT productId,prodName,description,price FROM covidprodts WHERE productId=?";
	public static final String GET_ALL_CP_QRY = "SELECT productId,prodName,description,price FROM covidprodts";

	@Override
	public CovidProds add(CovidProds covidprods) throws CovidProdException {
		if (covidprods != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_CP_QRY);) {
				pst.setInt(1, covidprods.getProdId());
				pst.setString(2, covidprods.getProdName());
				pst.setString(3, covidprods.getProdDesc());
				pst.setDouble(4, covidprods.getProdPrice());
				pst.executeUpdate();

			} catch (SQLException e) {
				throw new CovidProdException("An Error has occured,Could not add the Product");
			}
		}
		return covidprods;
	}

	@Override
	public CovidProds save(CovidProds covidprods) throws CovidProdException {
		if (covidprods != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_CP_QRY);) {

				pst.setString(1, covidprods.getProdName());
				pst.setString(2, covidprods.getProdDesc());
				pst.setDouble(3, covidprods.getProdPrice());
				pst.setInt(4, covidprods.getProdId());
				pst.executeUpdate();

			} catch (SQLException e) {
				throw new CovidProdException("An Error has occured,Could not save the Product details");
			}
		}
		return covidprods;
	}

	@Override
	public boolean deletebyId(int prodId) throws CovidProdException {
		boolean isDeleted = false;
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEl_CP_QRY);) {

			pst.setInt(1, prodId);

			int rowCount = pst.executeUpdate();
			isDeleted = rowCount > 0;
		} catch (SQLException e) {
			throw new CovidProdException("An Error has occured,Could not Delete the Product details");
		}
		return isDeleted;
	}

	
	public List<CovidProds> getAll() throws CovidProdException {
		List<CovidProds> covidprodts = new ArrayList<>();
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_ALL_CP_QRY);) {

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				CovidProds cprod = new CovidProds();
				cprod.setProdId(rs.getInt(1));
				cprod.setProdName(rs.getString(2));
				cprod.setProdDesc(rs.getString(3));
				cprod.setProdPrice(rs.getDouble(4));
				covidprodts.add(cprod);

			}

			if (covidprodts.isEmpty()) {
				covidprodts = null;
			}

		} catch (SQLException e) {
			throw new CovidProdException("An Error has occured,Could not retrieve the Products details");
		}

		return covidprodts;
	}

	@Override
	public CovidProds getById(int prodId) throws CovidProdException {
		CovidProds covidprod = null;
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_BY_ID_CP_QRY);) {
			pst.setInt(1, prodId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				covidprod = new CovidProds();
				covidprod.setProdId(rs.getInt(1));
				covidprod.setProdDesc(rs.getString(2));
				covidprod.setProdName(rs.getString(3));
				covidprod.setProdPrice(rs.getDouble(4));

			}

		} catch (SQLException e) {
			throw new CovidProdException("An Error has occured,Could retrieve save the Product details");
		}

		return covidprod;
	}

}
