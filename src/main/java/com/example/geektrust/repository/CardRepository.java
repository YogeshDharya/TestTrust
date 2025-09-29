package com.example.geektrust.repository;

import java.util.List;
import java.util.Map;

import com.example.geektrust.model.Card;

public interface CardRepository {
	public Card getCard(int id);
	public void addCard(Card card);
	public List<Card> getCards();
}
