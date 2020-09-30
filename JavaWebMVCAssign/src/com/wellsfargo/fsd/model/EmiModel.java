package com.wellsfargo.fsd.model;

public class EmiModel {
	
	private double principal;
	private int duration;
	private double roi;
	private double emiamount;
	
	public double getEmiamount() {
		return emiamount;
	}

	public void setEmiamount(double emiamount) {
		this.emiamount = emiamount;
	}
	

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getRoi() {
		return roi;
	}

	public void setRoi(double roi) {
		this.roi = roi;
	}

}
