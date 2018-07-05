package com.tactfactory.algotojava.tp18bis.model.poker;

import com.tactfactory.algotojava.tp18bis.model.Player;

public abstract class PokerPlayer extends Player {

	public PokerPlayer(double money, String name) {
		super(money, name);
	}

	public abstract PokerActions call();
}
