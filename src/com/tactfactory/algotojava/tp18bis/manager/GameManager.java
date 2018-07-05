package com.tactfactory.algotojava.tp18bis.manager;

import com.tactfactory.algotojava.tp18bis.model.Game;
import com.tactfactory.algotojava.tp18bis.model.Player;

public abstract class GameManager {

	private Game game;
	
	public Game getGame() {
		return game;
	}

	public GameManager(Game game) {
		super();
		this.game = game;
	}

	public abstract void play();
	public abstract void turn();

	public void addPlayer(Player player) throws Exception {
		this.game.addPlayer(player);
	}
}
