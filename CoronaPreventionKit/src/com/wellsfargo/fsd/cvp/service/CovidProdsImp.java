package com.wellsfargo.fsd.cvp.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.cvp.dao.CovidPrdDaoJdbcImp;
import com.wellsfargo.fsd.cvp.dao.CovidProdDao;
import com.wellsfargo.fsd.cvp.entity.CovidProds;
import com.wellsfargo.fsd.cvp.entity.UsersPortal;
import com.wellsfargo.fsd.cvp.exception.CovidProdException;

public class CovidProdsImp implements CovidProdsService {

	CovidProdDao covidproddao;

	public CovidProdsImp() {
		covidproddao = new CovidPrdDaoJdbcImp();
	}

	private boolean isValidProdId(Integer prodId) {
		return prodId != null && prodId > 0;
	}

	private boolean isValidProdName(String prodName) {
		return prodName != null && prodName.length() > 3 && prodName.length() < 10;
	}

	private boolean isValidDescrp(String descp) {
		return descp == null || (descp.length() > 10 && descp.length() < 30);
	}

	private boolean isValidPrice(Double price) {
		return price != null && price > 0;
	}

	private boolean isValidCovidProds(CovidProds covidprods) throws CovidProdException {
		boolean isValid = true;
		List<String> errMsgs = new ArrayList<>();

		if (covidprods != null) {
			if (!isValidProdId(covidprods.getProdId())) {
				isValid = false;
				errMsgs.add("Prod Id must be a positive non-repeatative number ");
			}
			if (!isValidProdName(covidprods.getProdName())) {
				isValid = false;
				errMsgs.add("Product Name must not be null and length between 3 and 10 characters ");
			}
			if (!isValidDescrp(covidprods.getProdDesc())) {
				isValid = false;
				errMsgs.add("length of Description must be a atleast 10 characters and maximum 30 characters ");
			}
			if (!isValidPrice(covidprods.getProdPrice())) {
				isValid = false;
				errMsgs.add("Price must be a positive and greater than 0");
			}
			if (!errMsgs.isEmpty()) {
				throw new CovidProdException(errMsgs.toString());
			}
		} else {
			isValid = false;
		}

		return isValid;

	}

	@Override
	public CovidProds ValidateandAdd(CovidProds covidprods) throws CovidProdException {
		if (isValidCovidProds(covidprods)) {
			covidproddao.add(covidprods);
		}
		return covidprods;
	}

	@Override
	public CovidProds ValidateandSave(CovidProds covidprods) throws CovidProdException {
		if (isValidCovidProds(covidprods)) {
			covidproddao.save(covidprods);
		}
		return covidprods;
	}

	@Override
	public boolean deletCovidProds(int prodId) throws CovidProdException {
		return covidproddao.deletebyId(prodId);
	}

	@Override
	public CovidProds getCovidProds(int prodId) throws CovidProdException {
		return covidproddao.getById(prodId);
	}

	@Override
	public List<CovidProds> getAllCovidProds() throws CovidProdException {
		return covidproddao.getAll();
	}

	
}
