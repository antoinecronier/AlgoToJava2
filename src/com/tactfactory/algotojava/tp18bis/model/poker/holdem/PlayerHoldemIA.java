package com.tactfactory.algotojava.tp18bis.model.poker.holdem;

import java.util.Random;

import com.tactfactory.algotojava.tp18bis.model.poker.PokerActions;

public class PlayerHoldemIA extends PlayerHoldem {

	public PlayerHoldemIA(double money, String name) {
		super(money, name);
	}

	@Override
	public PokerActions call() {
		Random rand = new Random();
		// PokerActions choice =
		// PokerActions.values()[rand.nextInt(PokerActions.values().length)
		// % (PokerActions.values().length-1)];
		PokerActions choice;

		int value = rand.nextInt(100);

		if (value > 70) {
			choice = PokerActions.RAISE;
		} else if (value > 15) {
			choice = PokerActions.CHECK;
		} else if (value > 1) {
			choice = PokerActions.PASS;
		} else {
			choice = PokerActions.LEAVE;
		}

		return choice;
	}
}
