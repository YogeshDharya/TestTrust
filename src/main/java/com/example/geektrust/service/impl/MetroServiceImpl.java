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

public class MetroServiceImpl implements MetroService {
	private static MetroServiceImpl metroService;
	private final CardRepository cardRepository;

	private final StationRepository stationRepository;

	private MetroServiceImpl(CardRepository cardRepo, StationRepository stationRepo) {
		this.cardRepository = cardRepo;
		this.stationRepository = stationRepo;
	}

	public static synchronized MetroServiceImpl getInstance(CardRepository cardRepo,
			StationRepository stationRepo) {
		if (metroService == null) {
			metroService = new MetroServiceImpl(cardRepo, stationRepo);
		}
		return metroService;
	}

	@Override
	public void balance(String cardId, int amount) {
		Card card = this.cardRepository.getCard(cardId);
		if (card == null) {
			card = new Card(cardId);
			this.cardRepository.addCard(card);
		}
		card.recharge(amount);
	}

	@Override
	public void checkIn(String cardId, PassengerType passengerType, String stationName) {
		Card card = this.cardRepository.getCard(cardId);
		if (card == null)
			throw new CardNotFoundException("This metro card " + cardId + " does not exist");
		Station station = this.stationRepository.getStation(stationName);
		if (station == null) {
			throw new StationNotFoundException("This station " + stationName + " does not exist");
		}
		FareStrategy strategy = FareStrategyFactory.getStrategy(passengerType);
		boolean isReturn =
				card.getLastStation() != null && !card.getLastStation().equals(stationName);

		int baseFare = strategy.calculateFare();
		int discount = isReturn ? (int) (baseFare * MetroConstants.DISCOUNT_RATE) : 0;
		int fare = baseFare - discount;
		if (card.getBalance() < fare) {
			int recharge = fare - card.getBalance();
			int fee = (int) Math.ceil((recharge * MetroConstants.SERVICE_FEE));
			card.recharge(recharge + fee);
			station.addRevenue(fee);
		}
		card.payFare(fare);
		if (isReturn) {
			card.markCheckInAt(null);
		} else {
			card.markCheckInAt(stationName);
		}
		station.addRevenue(fare);
		station.addPassenger(passengerType, 1);
		if (discount > 0) {
			station.addDiscount(discount);
		}
	}

	public void printSummary() {
		List<String> stationNames = Arrays.asList(MetroConstants.CENTRAL, MetroConstants.AIRPORT);

		for (String stationName : stationNames) {
			Station station = stationRepository.getStation(stationName);
			if (station != null) {
				SummaryDto summaryDto = station.getSummaryDTO();
				System.out.print(summaryDto.formatSummary(stationName));
			}
		}
	}

	@Override
	public CardRepository getCardRepository() {
		return this.cardRepository;
	}

	@Override
	public StationRepository getStationRepository() {
		return this.stationRepository;
	}

}
