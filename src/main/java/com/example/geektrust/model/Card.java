package com.example.geektrust.model;


public class Card {
	private String id ;
	private int userId;
	//TODO: default balance so no need in the constructor 
	//TODO: It should be having the user id and not the user name
	private int balance ;
	private String lastStation;
	public Card(String id,int balance, String station) {
		this.id = id;
		this.lastStation = station;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public int getUserId() {
		return userId;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void addBalance(int amount) {
		this.balance += amount;
	}
	public void deductBalance(int amount) {
		this.balance -= amount;
	}
		
	public String getLastStation() {
		return lastStation;
	}
	public void setLastStation(String lastStation) {
		this.lastStation = lastStation;
	}
	
}