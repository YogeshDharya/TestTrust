package com.example.geektrust.model;


public class Card {
	private String id ;
	private int balance ;
	private String lastStation;
	public Card(String id){
		this.id=id;
		this.lastStation=null;
		this.balance=0;
	}
	public Card(String id,int balance, String station) {
		this.id = id;
		this.lastStation = station;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public int getBalance() {
		return balance;
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