package com.ttc.springapp.dto;

public class ProductModel { 
	
	private String  product;
	private float price;
	private int quantity;
	
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductModel() {
		super();
	}
	
	
	
}
