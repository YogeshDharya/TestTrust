package com.example.geektrust.service.impl;

import java.util.Arrays;
import java.util.List;

import com.example.geektrust.constant.MetroConstants;
import com.example.geektrust.constant.PassengerType;
import com.example.geektrust.exception.CardNotFoundException;
import com.example.geektrust.exception.StationNotFoundException;
import com.example.geektrust.factory.FareStrategyFactory;
import com.example.geektrust.model.Card;
import com.example.geektrust.model.Station;
import com.example.geektrust.model.SummaryDto;
import com.example.geektrust.repository.CardRepository;
import com.example.geektrust.repository.StationRepository;
import com.example.geektrust.service.MetroService;
import com.example.geektrust.strategy.FareStrategy;

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
			metroService = new MetroServiceImpl(cardRepo,stationRepo);
		}
		return metroService;
	}
	@Override
	public void balance(String cardId, int amount) {
		System.out.println("Entered Balance command for cardId "+ cardId + " param amount " + amount);
		Card card = this.cardRepository.getCard(cardId);
		if(card == null){
			card = new Card(cardId);
			this.cardRepository.addCard(card);
		}
		card.addBalance(amount);
	}

	@Override
	public void checkIn(String cardId, PassengerType passengerType, String stationName) {
		System.out.println("Entered check in command for cardId "+ cardId + " passenger type " + passengerType + " station " + stationName);
		Card card = this.cardRepository.getCard(cardId);
		if(card == null) throw new CardNotFoundException("@ MetroServiceImpl.checkIn: This metro card "+ cardId + " does not exist");
		Station station = this.stationRepository.getStation(stationName);
		if(station == null){
			throw new StationNotFoundException("@ MetroServiceImpl.checkIn: This station " + stationName + " does not exist");
		}
		FareStrategy strategy = FareStrategyFactory.getStrategy(passengerType);
		boolean isReturn = card.getLastStation() != null && !card.getLastStation().isEmpty()  && !card.getLastStation().equals(stationName);
		System.out.println("Chosen strategy "+ strategy + " shall we be returning back 0=false 1=true " +isReturn );
		int fullFare = strategy.calculateFare(isReturn);
		int fare = passengerType.getFare();
		int discount = isReturn ? fullFare / 2 : 0;
		// int discount = isReturn ? (int)(fare*MetroConstants.DISCOUNT_RATE) : 0;
		fare -= discount;
		if(discount > 0){
			station.addDiscount(discount);
		}
		if(card.getBalance() < fare){
			int recharge = fare - card.getBalance();
			int fee  = (int)(recharge * MetroConstants.SERVICE_FEE);
			card.addBalance(recharge+fee);
			station.addRevenue(fee);
			//TODO: If we will throw a checked excption here will it stop the programme ? 
			System.out.println("@ MetroServiceImpl.checkIn: Recharging the metro card " + cardId + " with fee" + fee);
		}
		card.deductBalance(fare);
		card.setLastStation(stationName);
		station.addRevenue(fare);
		station.addPassenger(passengerType, 1);
		station.addDiscount(discount);
		System.out.println("leaving checkIn cmd for the cardId " + cardId +" passenger " + passengerType + " discount " + discount + " last station " + stationName + " fare " + fare);
	}

	public void printSummary() {
		   List<String> stationNames = Arrays.asList(MetroConstants.CENTRAL, MetroConstants.AIRPORT);
    
		   for (String stationName : stationNames) {
			   Station station = stationRepository.getStation(stationName);
			   if (station != null) {
				   SummaryDto summary = station.getSummaryDTO();
				   System.out.println(summary.formatSummary(stationName));//This line had .print() n not println() before 
			   }
		   }
	}

}

