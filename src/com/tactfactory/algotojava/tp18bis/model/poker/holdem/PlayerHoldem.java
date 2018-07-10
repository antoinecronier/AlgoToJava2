package com.tactfactory.algotojava.tp18bis.model.poker.holdem;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp18bis.model.Card;
import com.tactfactory.algotojava.tp18bis.model.Family;
import com.tactfactory.algotojava.tp18bis.model.Printable;
import com.tactfactory.algotojava.tp18bis.model.poker.PokerPlayer;

public abstract class PlayerHoldem extends PokerPlayer implements Printable {

	private double currentBet;
	private List<Card> table;

	public double getCurrentBet() {
		return currentBet;
	}

	public void setCurrentBet(double currentBet) {
		this.currentBet = currentBet;
	}

	public List<Card> getTable() {
		return table;
	}

	@Override
	public List<Card> getCards() {
		List<Card> cards = new ArrayList<Card>(this.getTable());
		cards.addAll(this.getHand());
		return cards;
	}

	public PlayerHoldem(double money, String name) {
		super(money, name);
		this.table = new ArrayList<Card>();
	}

	public boolean canCheck(double value) {
		boolean result = false;

		if (this.getMoney() - value >= 0) {
			result = true;
		}

		return result;
	}

	public double canRaise(double checkPrice, double pot) {
		double result = -1;

		if (this.getMoney() - ((pot / 2) + (checkPrice - this.getCurrentBet())) >= 0) {
			result = checkPrice - this.getCurrentBet() + (pot / 2);
		}

		return result;
	}

	@Override
	public void print() {
		System.out.println("Cards for player " + this.getName());

		StringBuilder builder = new StringBuilder();
		List<String> strings = new ArrayList<String>();
		
		for (int i = 0; i < Family.SIZE_REPRESENTATION; i++) {
			for (int j = 0; j < this.getHand().size(); j++) {
				builder.append(this.getHand().get(j).printExpression().get(i) + "  ");
			}
			
			strings.add(builder.toString());
			builder = new StringBuilder();
		}
		
		for (String string : strings) {
			builder.append(string+"\n");
		}
		
		System.out.println(builder.toString());
	}
}
