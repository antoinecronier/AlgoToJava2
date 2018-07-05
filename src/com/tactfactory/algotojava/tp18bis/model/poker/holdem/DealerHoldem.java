package com.tactfactory.algotojava.tp18bis.model.poker.holdem;

import java.util.List;

import com.tactfactory.algotojava.tp18bis.model.Card;
import com.tactfactory.algotojava.tp18bis.model.Dealer;
import com.tactfactory.algotojava.tp18bis.model.Player;
import com.tactfactory.algotojava.tp18bis.model.poker.PokerDeck;

public class DealerHoldem extends Dealer implements HoldemDealer {

	public DealerHoldem() {
		super();
		this.setDeck(new PokerDeck());
	}

	@Override
	public void dealCards(Player player) {
		player.getCards().add(((PokerDeck)this.getDeck()).dealACard());
	}

	@Override
	public void dealInitialCards(List<Player> players) {
		for (Player player : players) {
			for (int i = 0; i < 2; i++) {
				dealCards(player);
			}
		}
	}

	@Override
	public void endTurn(List<Player> players) {
	}

	@Override
	public void retreiveCard(Card card) {
	}

	@Override
	public void renewDeck() {
	}

}
