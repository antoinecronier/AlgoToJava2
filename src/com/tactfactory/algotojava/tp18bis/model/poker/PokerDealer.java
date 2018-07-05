package com.tactfactory.algotojava.tp18bis.model.poker;

import java.util.List;

import com.tactfactory.algotojava.tp18bis.model.Card;
import com.tactfactory.algotojava.tp18bis.model.Player;

public interface PokerDealer {

	void dealCards(Player player);
	void dealInitialCards(List<Player> players);
	void retreiveCard(Card card);
	void renewDeck();
}
