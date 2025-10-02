package com.example.geektrust.service.impl;

import java.util.Arrays;
import java.util.List;

import com.example.geektrust.constant.MetroConstants;
import com.example.geektrust.constant.PassengerType;
import com.example.geektrust.exception.CardNotFoundException;
import com.example.geektrust.exception.StationNotFoundException;
import com.example.geektrust.model.Card;
import com.example.geektrust.model.Station;
import com.example.geektrust.model.SummaryDto;
import com.example.geektrust.repository.CardRepository;
import com.example.geektrust.repository.StationRepository;
import com.example.geektrust.service.MetroService;

public class MetroServiceImpl implements MetroService{
	private static MetroServiceImpl metroService;
	private final CardRepository cardRepository;
	private final StationRepository stationRepository;
	private MetroServiceImpl(CardRepository cardRepo,StationRepository stationRepo) {
		this.cardRepository=cardRepo;
		this.stationRepository=stationRepo;
	}
	public static synchronized MetroServiceImpl getInstance(CardRepository cardRepo,StationRepository stationRepo) {
		if(metroService == null) {
			return new MetroServiceImpl(cardRepo,stationRepo);
		}
		return metroService;
	}
	@Override
	public void balance(int cardId, int amount) {
		this.cardRepository.getCard(cardId).addBalance(amount);
		
	}

	@Override
	public void checkIn(int cardId, PassengerType passengerType, String stationName) {
		Card card = this.cardRepository.getCard(cardId);
		if(card == null) throw new CardNotFoundException("This metro card "+ cardId + " does not exist");
		Station station = this.stationRepository.getStation(stationName);
		if(station == null){
			throw new StationNotFoundException("This station " + stationName + " does not exist");
		}
		boolean isReturn = !card.getLastStation().isEmpty()	&& !card.getLastStation().equals(stationName);
		int fare = passengerType.getFare();
		int discount = isReturn ? (int)(fare*MetroConstants.DISCOUNT_RATE) : 0;
		fare -= discount;
		if(discount > 0){
			station.addDiscount(discount);
		}
		if(card.getBalance() < fare){
			int recharge = fare - card.getBalance();
			int fee  = (int)(recharge * MetroConstants.SERVICE_FEE);
			card.addBalance(recharge+fee);
			station.addRevenue(fee);
		}
		card.deductBalance(fare);
		card.setLastStation(stationName);
		station.addRevenue(fare);
		station.addPassenger(passengerType, 1);
	}

	public void printSummary() {
		   List<String> stationNames = Arrays.asList(MetroConstants.CENTRAL, MetroConstants.AIRPORT);
    
		   for (String stationName : stationNames) {
			   Station station = stationRepository.getStation(stationName);
			   if (station != null) {
				   SummaryDto summary = station.getSummaryDTO();
				   System.out.print(summary.formatSummary(stationName));
			   }
		   }
	}

}

