package com.tactfactory.algotojava.tp18bis.manager;

import com.tactfactory.algotojava.tp18bis.model.Game;
import com.tactfactory.algotojava.tp18bis.model.poker.holdem.GameHoldem;

public class HoldemGameManager extends GameManager {

	GameHoldem currentGame;

	public HoldemGameManager(GameHoldem game) {
		super((Game) game);
		this.currentGame = game;
	}

	@Override
	public void play() {
		while (currentGame.getPlayers().size() > 1) {
			turn();
		}
	}

	@Override
	public void turn() {
		this.currentGame.dealFirstTurnCards();
		System.out.println("Les joueurs reçoivent leurs cartes");
		this.currentGame.initialBet();
		System.out.println("Les small et big blind posent leurs mises obligatoire");
		this.currentGame.bet();
		System.out.println("Premier tour de mise");
		this.currentGame.dealFlopCards();
		System.out.println("Arrivé du flop");
		this.currentGame.print();
		this.currentGame.bet();
		System.out.println("Deuxième tour de mise");
		this.currentGame.dealTurnCards();
		System.out.println("Arrivé du turn");
		this.currentGame.print();
		this.currentGame.bet();
		System.out.println("Troisième tour de mise");
		this.currentGame.dealRiverCards();
		System.out.println("Arrivé de la river");
		this.currentGame.print();
		this.currentGame.bet();
		System.out.println("Quatrième tour de mise");
		this.currentGame.endTurn();
		System.out.println("Fin du tour");
	}

}
