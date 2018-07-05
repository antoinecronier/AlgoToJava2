package com.tactfactory.algotojava.tp18bis.model;

import java.util.ArrayList;
import java.util.List;

public class Deck implements Printable {

	private List<Card> deck;

	public List<Card> getDeck() {
		return deck;
	}

	public Deck() {
		this.deck = new ArrayList<Card>();
		initPokerDeck();
	}

	private void initPokerDeck() {
		for (int i = 0; i < Coeur.POKER_DECK.length; i++) {
			this.deck
					.add(new Card(new CardValue(Coeur.POKER_DECK[i][0], Coeur.POKER_DECK[i][1], Integer.parseInt(Coeur.POKER_DECK[i][2])),
							new Coeur()));
		}

		for (int i = 0; i < Carreau.POKER_DECK.length; i++) {
			this.deck
					.add(new Card(new CardValue(Carreau.POKER_DECK[i][0], Carreau.POKER_DECK[i][1], Integer.parseInt(Carreau.POKER_DECK[i][2])),
							new Carreau()));
		}

		for (int i = 0; i < Pique.POKER_DECK.length; i++) {
			this.deck
					.add(new Card(new CardValue(Pique.POKER_DECK[i][0], Pique.POKER_DECK[i][1], Integer.parseInt(Pique.POKER_DECK[i][2])),
							new Pique()));
		}

		for (int i = 0; i < Trefle.POKER_DECK.length; i++) {
			this.deck
					.add(new Card(new CardValue(Trefle.POKER_DECK[i][0], Trefle.POKER_DECK[i][1], Integer.parseInt(Trefle.POKER_DECK[i][2])),
							new Trefle()));
		}
	}

	@Override
	public void print() {
		for (Card card : deck) {
			card.print();
		}
	}
}
