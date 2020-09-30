package com.wellsfargo.fsd.cvp.entity;

public class CovidProds {
	
	private Integer prodId;
	private String prodName;
	private String prodDesc;
	private Double prodPrice;
	
	public CovidProds() {
		
	}

	public CovidProds(Integer prodId, String prodName, String prodDesc, Double prodPrice) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.prodPrice = prodPrice;
	}

	

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public Double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}

	@Override
	public String toString() {
		return "CovidProds [prodId=" + prodId + ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", prodPrice="
				+ prodPrice + "]";
	}
	

}
