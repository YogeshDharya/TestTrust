package com.example.geektrust.service;

import com.example.geektrust.constant.PassengerType;

public interface MetroService {
	public void balance(int cardId, int amount);
	public void checkIn(int cardId,PassengerType passengerType,String station);
	public void printSummary() ;
}
