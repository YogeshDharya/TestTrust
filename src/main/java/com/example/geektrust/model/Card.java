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
	public void recharge(int amount) {
		if(amount <= 0){
			throw new IllegalArgumentException(" The recharge amount " + amount + " is invalid");
		}
		this.balance += amount;
	}
	public void payFare(int fare) {
		if(fare > this.balance){
			throw new IllegalStateException("Entered fare " + fare + " is greater than the existing balance " + this.balance);
		}
		this.balance -= fare;
	}
		
	public String getLastStation() {
		return lastStation;
	}
	public void markCheckInAt(String stationName) {
		if(stationName == null || stationName.isEmpty()){
			throw new IllegalArgumentException(stationName + " is not a valid station name");
		}
		this.lastStation = stationName;
	}	
}