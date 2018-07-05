package com.tactfactory.algotojava.tp18bis.model.poker.holdem;

import com.tactfactory.algotojava.tp18bis.model.poker.PokerPlayer;

public abstract class PlayerHoldem extends PokerPlayer {

	private double currentBet;

	public double getCurrentBet() {
		return currentBet;
	}

	public void setCurrentBet(double currentBet) {
		this.currentBet = currentBet;
	}

	public PlayerHoldem(double money, String name) {
		super(money, name);
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
}
