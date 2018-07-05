package com.tactfactory.algotojava.tp18bis.model.poker;

import com.tactfactory.algotojava.tp18bis.model.Game;
import com.tactfactory.algotojava.tp18bis.model.Player;

public interface PokerGame extends Game {

	void dealFirstTurnCards();
	double getPot();
	Player getNext(Player player);
	Player getPrevious(Player player);
	void bet();
}
