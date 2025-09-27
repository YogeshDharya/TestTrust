package com.example.geektrust.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.model.Card;

public class CardRepository {
	private Map<Integer,Card> cards;
	public CardRepository() {
		this.cards = new HashMap<>();
	}
	
	public Card getCard(int id) {
		return this.cards.get(id);
	}
	public void addCard(Card card) {
		this.cards.put(card.getId(), card);
	}
	public Map<Integer,Card> getCards(){
		return this.getCards();
	}
}
