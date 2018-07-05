package com.tactfactory.algotojava.tp18bis.model.poker.holdem;

import com.tactfactory.algotojava.tp18bis.model.Player;
import com.tactfactory.algotojava.tp18bis.model.poker.PokerGame;

public interface HoldemGame extends PokerGame {

	Player getBigBlind();
	Player getSmallBlind();
	void initialBet();
	void dealFlopCards();
	void dealTurnCards();
	void dealRiverCards();
}
