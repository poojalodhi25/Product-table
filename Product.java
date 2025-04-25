package com.pojo;
//pojo plain old java project class
//dto data transfer object class
public class Product {
	private int pId;
	private String pName;
	private double price;
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Product(int pId, String pName, double price) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.price = price;
	}
	

	public int getpId() {
		return pId;
	}


	public void setpId(int pId) {
		this.pId = pId;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	

	

}
