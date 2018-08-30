package com.tactfactory.algotojava.tp18bis.model.poker;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp18bis.model.Card;
import com.tactfactory.algotojava.tp18bis.model.Player;

public abstract class PokerPlayer extends Player {

	private List<Card> hand;
	
	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public PokerPlayer(double money, String name) {
		super(money, name);
		this.hand = new ArrayList<Card>();
	}

	public abstract PokerActions call();
}
