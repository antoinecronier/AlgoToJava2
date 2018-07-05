package com.tactfactory.algotojava.tp18bis.model.poker.holdem;

import java.util.List;

import com.tactfactory.algotojava.tp18bis.model.Player;

public class GameHoldem implements HoldemGame {

	List<Player> players;
	DealerHoldem dealer;
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public DealerHoldem getDealer() {
		return dealer;
	}

	public GameHoldem(List<Player> players, DealerHoldem dealer) {
		super();
		this.players = players;
		this.dealer = dealer;
	}

	@Override
	public void DealFirstTurnCards() {
		dealer.dealInitialCards(players);
	}
}
