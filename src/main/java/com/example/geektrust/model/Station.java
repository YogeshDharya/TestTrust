package com.example.geektrust.model;

public class Station {
	private final String name;
	private int id;
	private int discount;
	//TODO: inc or something more relavant ? revenue or collection 
	private int inc = 0 ;
	private int revenue;
	public Station(String name) {
		this.id = inc++;
		this.name=name;
	}
	public void addRevenue(int amount) {
		this.revenue += amount;
	}
	public void addDiscount(int amount) {
		this.discount += amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getRevenue() {
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	public String getName() {
		return name;
	}
	
}
