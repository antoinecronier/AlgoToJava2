package com.tactfactory.algotojava.tp18bis.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck implements Printable {

	protected List<Card> deck;

	public List<Card> getDeck() {
		return deck;
	}

	public Deck() {
		this.deck = new ArrayList<Card>();
	}

	@Override
	public void print() {
		for (Card card : deck) {
			card.print();
		}
	}
}
