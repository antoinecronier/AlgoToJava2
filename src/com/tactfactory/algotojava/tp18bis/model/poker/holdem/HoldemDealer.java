package com.tactfactory.algotojava.tp18bis.model.poker.holdem;

import com.tactfactory.algotojava.tp18bis.model.Card;
import com.tactfactory.algotojava.tp18bis.model.poker.PokerDealer;

public interface HoldemDealer extends PokerDealer {

	void burnCard();
	Card giveCard();
}
