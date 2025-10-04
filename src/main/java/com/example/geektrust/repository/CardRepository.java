package com.example.geektrust.repository;

import java.util.Map;

import com.example.geektrust.model.Card;

public interface CardRepository {
	public Card getCard(String id);
	public void addCard(Card card);
	//public List<Card> getCards();
	public Map<String,Card> getCards();
}
