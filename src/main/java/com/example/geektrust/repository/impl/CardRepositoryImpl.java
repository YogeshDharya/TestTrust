package com.example.geektrust.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.geektrust.model.Card;
import com.example.geektrust.repository.CardRepository;

public class CardRepositoryImpl implements CardRepository{
	private Map<Integer,Card> cards;
	public CardRepositoryImpl() {
		this.cards = new HashMap<>();
	}
	
	@Override
	public Card getCard(int id) {
		return this.cards.get(id);
	}
	@Override
	public void addCard(Card card) {
		this.cards.put(card.getId(), card);
	}
	@Override
	public List<Card> getCards(){
		List<Card> cards = new ArrayList<>();
		for(int i = 0 ; i < this.cards.size() ; i ++) {
			cards.add(this.cards.get(i));
		}
		return cards;
	}
}
