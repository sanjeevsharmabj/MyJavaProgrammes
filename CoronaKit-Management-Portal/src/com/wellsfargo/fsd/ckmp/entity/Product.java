package com.wellsfargo.fsd.ckmp.entity;

public class Product {
	
	private Integer productId;
	private String productName;
	private Double productCost;
	private String productDesc;
	
	public Product() {
		
	}
	
	public Product(Integer productId, String productName, Double productCost, String productDesc) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.productDesc = productDesc;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductCost() {
		return productCost;
	}

	public void setProductCost(Double productCost) {
		this.productCost = productCost;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", productDesc=" + productDesc + "]";
	}
	
	
}
