package com.niit.domain;


public class Item {

	private Product p= new Product();
	private int quantity;
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item(Product p, int quantity) {
		super();
		this.p = p;
		this.quantity = quantity;
	}
	public Item() {
		super();
	}
	
}
