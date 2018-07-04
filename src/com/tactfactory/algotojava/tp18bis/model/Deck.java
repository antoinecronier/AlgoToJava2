package com.tactfactory.algotojava.tp18bis.model;

import java.util.ArrayList;
import java.util.List;

public class Deck implements Printable {

	private final static String[][] POKER_DECK = new String[][] { { "A ", "_A", "14" }, { "R ", "_R", "13" },
			{ "D ", "_D", "12" }, { "V ", "_V", "11" }, { "10", "10", "10" }, { "9 ", "_9", "9" }, { "8 ", "_8", "8" },
			{ "7 ", "_7", "7" }, };

	private List<Card> deck;

	public List<Card> getDeck() {
		return deck;
	}

	public Deck() {
		this.deck = new ArrayList<Card>();
		initPokerDeck();
	}

	private void initPokerDeck() {
		for (int i = 0; i < POKER_DECK.length; i++) {
			this.deck
					.add(new Card(new CardValue(POKER_DECK[i][0], POKER_DECK[i][1], Integer.parseInt(POKER_DECK[i][2])),
							new Coeur()));
		}

		for (int i = 0; i < POKER_DECK.length; i++) {
			this.deck
					.add(new Card(new CardValue(POKER_DECK[i][0], POKER_DECK[i][1], Integer.parseInt(POKER_DECK[i][2])),
							new Carreau()));
		}

		for (int i = 0; i < POKER_DECK.length; i++) {
			this.deck
					.add(new Card(new CardValue(POKER_DECK[i][0], POKER_DECK[i][1], Integer.parseInt(POKER_DECK[i][2])),
							new Pique()));
		}

		for (int i = 0; i < POKER_DECK.length; i++) {
			this.deck
					.add(new Card(new CardValue(POKER_DECK[i][0], POKER_DECK[i][1], Integer.parseInt(POKER_DECK[i][2])),
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
