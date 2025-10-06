package com.example.geektrust.service;

import com.example.geektrust.constant.PassengerType;
import com.example.geektrust.repository.CardRepository;
import com.example.geektrust.repository.StationRepository;

public interface MetroService {
	public void balance(String cardId, int amount);
	public void checkIn(String cardId,PassengerType passengerType,String station);
	public void printSummary();
	public CardRepository getCardRepository();
	public StationRepository getStationRepository();

}
