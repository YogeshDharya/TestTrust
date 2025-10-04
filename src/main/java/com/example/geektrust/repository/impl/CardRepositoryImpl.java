package com.example.geektrust.repository.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.model.Card;
import com.example.geektrust.repository.CardRepository;

public class CardRepositoryImpl implements CardRepository {
	private Map<String, Card> cards;
	private static CardRepositoryImpl instance;
	private CardRepositoryImpl() {
		this.cards = new HashMap<>();
	}
	public static CardRepositoryImpl getInstance(){
		if(instance == null){
			instance = new CardRepositoryImpl();
		}
		return instance;
	}
	@Override
	public Card getCard(String id) {
		return this.cards.get(id);
	}

	@Override
	public void addCard(Card card) {
		this.cards.put(card.getId(), card);
	}

	@Override
	public Map<String,Card> getCards() {
		return new HashMap<>(this.cards);
	}
	// @Override
	// public List<Card> getCards() {
	// 	return new ArrayList<>(this.cards.values());
	// }
}
