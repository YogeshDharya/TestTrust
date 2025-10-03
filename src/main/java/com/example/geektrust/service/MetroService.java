package com.example.geektrust.service;

import com.example.geektrust.constant.PassengerType;

public interface MetroService {
	public void balance(String cardId, int amount);
	public void checkIn(String cardId,PassengerType passengerType,String station);
	public void printSummary();
}
