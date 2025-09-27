package com.example.geektrust.model;


public class Card {
	private int id ;
	private int userId;
	private int inc = 0 ;
	//TODO: default balance so no need in the constructor 
	//TODO: It should be having the user id and not the user name
	private int balance ;
	private String lastStation;
	public Card(int balance, String station) {
		this.id = inc ++;
		this.lastStation = station;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public int getUserId() {
		return userId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
//	TODO: should we have addBalance method here or may be at the file that uses for such small
	// Business logic
	public void addBalance(int amount) {
		this.balance += amount;
	}
		
	public String getLastStation() {
		return lastStation;
	}
	public void setLastStation(String lastStation) {
		this.lastStation = lastStation;
	}
	
}
