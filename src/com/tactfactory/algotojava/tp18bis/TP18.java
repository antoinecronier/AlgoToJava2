package com.tactfactory.algotojava.tp18bis;

import java.util.ArrayList;

import com.tactfactory.algotojava.tp18bis.model.Card;
import com.tactfactory.algotojava.tp18bis.model.CardValue;
import com.tactfactory.algotojava.tp18bis.model.Carreau;
import com.tactfactory.algotojava.tp18bis.model.Deck;
import com.tactfactory.algotojava.tp18bis.model.Pique;
import com.tactfactory.algotojava.tp18bis.model.Player;
import com.tactfactory.algotojava.tp18bis.model.Trefle;
import com.tactfactory.algotojava.tp18bis.model.poker.holdem.DealerHoldem;
import com.tactfactory.algotojava.tp18bis.model.poker.holdem.GameHoldem;

/**
 * 
 * Créer un programme permettant de joueur au poker contre une ia. On pourra
 * jouer selon 2 modes de jeu différent : - poker français : - 5 cartes par
 * joueur au départ - mise de départ - sélection de 0 à 3 cartes à jeter, qui
 * seront remplacé par de nouvelles cartes - mise - fin du tour - texas hold'em
 * - 2 cartes par joueur non visible - mise obligatoire pour le small
 * blind(moitié de la mise de départ) et le big blind(mise de départ à payer) -
 * cartes regardable - mise - disposition de 3 cartes sur la table - mise -
 * disposition d'1 nouvelle carte sur la table - mise - disposition d'1 nouvelle
 * carte sur la table - mise - composition d'une main par joueur avec les cartes
 * de ça main et de la table - fin du tour
 * 
 * Un jeu de poker est composé de 32 cartes : - valeur de 7 à 10 puis des têtes
 * (valet, dame, roi, as) - famille (pique, carreau, trèfle, coeur) - il
 * n'existe qu'une seul combinaison de valeur et de couleur possible
 * 
 * Les participants d'une partie pourront aller de 2 à 4 joueurs chaque joueur
 * possédera un montant d'argent à miser, si un joueur n'a plus d'argent il est
 * éliminé
 * 
 * Le jeu se passera sur une table de poker
 * 
 * Les combinaisons possible à réalisé sont les suivantes : - carte haute
 * (valeur de la carte avec l'ordre de la famille => coeur, carreau, pique,
 * trèfle) - paire (2 cartes identique en valeur) - double paire (2 cartes
 * identique en valeur, 2 fois) - brelan (3 cartes identique en valeur) - suite
 * (5 cartes se suivant en valeur) - couleur (5 cartes de la même famille) -
 * full (paire + brelan) - carré (4 cartes identique en valeur) - quinte flush
 * (suite + couleur) - quinte flush royal (suite + couleur avec as)
 * 
 * Si deux combinaisons identique rentre en concurrence celle avec la carte de
 * plus haute valeur gagne la règle de la carte haute est appliqué en cas de re
 * égalité
 * 
 * Le donneur est celui qui distribue les cartes et il change à chaque tour dans
 * le sens des aiguilles d'une montre Le premier donneur est sélectionné si il
 * est le plus jeune des joueurs
 * 
 * La gestion des mises se font selon les règles suivantes : - choix d'une mise
 * minimal de départ avant le jeu - un joueur peux relancer au minimum de la
 * moitié du pot(somme de l'argent payer par tout les joueurs) - si un joueur
 * relance un nouveau tour de paye est lancé - un joueur pourra : - se coucher
 * (partir de la partie sans les sous déjà posé sur la table) - checker (ne pas
 * miser plus que se qui est déjà présent) - relancer - un tour de mise se fini
 * une fois que toutes les personnes se sont aligné sur la dernière mise ou
 * couché
 * 
 * 
 * Avoir les notions dans votre code de : - carte - table - main - pot -
 * combinaison - joueur - mise - tour de jeu - jeu
 * 
 * Le jeux s'arrêtera quand le joueur humain quittera la table ou n'aura plus
 * d'argent ou qu'il sera le seul joueur à la table.
 * 
 * @author tactfactory
 *
 */
public class TP18 {

	public static void main(String[] args) {
		Deck pokerDeck = new Deck();
		pokerDeck.print();

		GameHoldem game = null;
		try {
			game = new GameHoldem(new ArrayList<Player>() {
				{
					add(new Player(200.00, "player1"));
					add(new Player(200.00, "player2"));
					add(new Player(200.00, "player3"));
					add(new Player(200.00, "player4"));
				}
			}, new DealerHoldem());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		game.DealFirstTurnCards();
		
		for (Player player : game.getPlayers()) {
			System.out.println("Card for player " + player.getName());
			for (Card card : player.getCards()) {
				card.print();
			}
		}
		
		System.out.println(game.getDealer().getDeck().getDeck().size());
	}

}
