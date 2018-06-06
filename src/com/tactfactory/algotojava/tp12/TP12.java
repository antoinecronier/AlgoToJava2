package com.tactfactory.algotojava.tp12;

import com.tactfactory.algotojava.tp12.utils.Conjugateur;

/**
 * 
 * @author tactfactory
 *
 * 	- Ecrire une fonction qui prend un verbe du premier groupe et qui le conjugue au présent de
 *		l’indicatif
 *	- La fonction devra retourner un tableau de chaine contenant le verbe conjugué pour chacun
 *		des pronoms
 *	- Ecrire un algorithme qui utilise cette fonction et qui affiche le tableau de résultat à
 *		l’utilisateur
 *
 */
public class TP12 {

	public static void main(String[] args){
		Conjugateur.autoConjugue(new String[]{
				"accepter",
				"entrer",
				"préparer",
				"acheter",
				"envoyer",
				"présenter",
				"aider",
				"espérer",
				"prier",
				"aimer",
				"essayer",
				"prononcer",
				"manger"
				});
		Conjugateur.conjugueAvecSaisi();
	}
}
