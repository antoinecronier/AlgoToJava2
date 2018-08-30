package com.tactfactory.algotojava.tp18bis;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp18bis.manager.GameManager;
import com.tactfactory.algotojava.tp18bis.manager.HoldemGameManager;
import com.tactfactory.algotojava.tp18bis.model.Card;
import com.tactfactory.algotojava.tp18bis.model.CardValue;
import com.tactfactory.algotojava.tp18bis.model.Carreau;
import com.tactfactory.algotojava.tp18bis.model.Coeur;
import com.tactfactory.algotojava.tp18bis.model.Deck;
import com.tactfactory.algotojava.tp18bis.model.Pique;
import com.tactfactory.algotojava.tp18bis.model.Player;
import com.tactfactory.algotojava.tp18bis.model.Trefle;
import com.tactfactory.algotojava.tp18bis.model.poker.PokerUtil;
import com.tactfactory.algotojava.tp18bis.model.poker.holdem.DealerHoldem;
import com.tactfactory.algotojava.tp18bis.model.poker.holdem.GameHoldem;
import com.tactfactory.algotojava.tp18bis.model.poker.holdem.PlayerHoldem;
import com.tactfactory.algotojava.tp18bis.model.poker.holdem.PlayerHoldemHuman;
import com.tactfactory.algotojava.tp18bis.model.poker.holdem.PlayerHoldemIA;
import com.tactfactory.algotojava.tp18bis.utils.ListUtil;

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
//		Player p1 = new PlayerHoldemHuman(200.00, "Player1");
//		Coeur coeur = new Coeur();
//		p1.getCards().add(new Card(new CardValue("A ", "_A", 11), coeur));
//		p1.getCards().add(new Card(new CardValue("A ", "_A", 10), coeur));
//		p1.getCards().add(new Card(new CardValue("A ", "_A", 14), coeur));
//		p1.getCards().add(new Card(new CardValue("A ", "_A", 13), coeur));
//		p1.getCards().add(new Card(new CardValue("A ", "_A", 12), coeur));
//		p1.getCards().add(new Card(new CardValue("A ", "_A", 14), coeur));
//		p1.getCards().add(new Card(new CardValue("A ", "_A", 14), coeur));
//
//		boolean test = false;
//		test = PokerUtil.testPair(new ArrayList<Card>(p1.getCards()));
//		test = PokerUtil.testDoublePair(new ArrayList<Card>(p1.getCards()));
//		test = PokerUtil.testBrelan(new ArrayList<Card>(p1.getCards()));
//		test = PokerUtil.testQuintes(new ArrayList<Card>(p1.getCards()));
//		test = PokerUtil.testColor(new ArrayList<Card>(p1.getCards()));
//		test = PokerUtil.testFull(new ArrayList<Card>(p1.getCards()));
//		test = PokerUtil.testSquare(new ArrayList<Card>(p1.getCards()));
//		test = PokerUtil.testQuinteFlush(new ArrayList<Card>(p1.getCards()));

		List<PlayerHoldem> players = new ArrayList<PlayerHoldem>();
		players.add(new PlayerHoldemIA(200.00, "Player1"));
		players.add(new PlayerHoldemIA(200.00, "Player2"));
		players.add(new PlayerHoldemIA(200.00, "Player3"));
		players.add(new PlayerHoldemIA(200.00, "Player4"));

		GameManager holdem = null;
		try {
			holdem = new HoldemGameManager(new GameHoldem(players, new DealerHoldem(), 0.5));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		holdem.play();
	}

}
