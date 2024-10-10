package com.ttc.springapp.entities;

import jakarta.persistence.*;

@Entity
@Table( name="products" )
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column( name="product_name", nullable=false )
	private String product;
	@Column( name="product_quantity", nullable=false )
	private int quantity;
	@Column( name="product_price", nullable=false )
	private float price;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Product(long id, String product, int quantity, float price) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	public Product() {
		super();
	}
	
	
	
	

}
