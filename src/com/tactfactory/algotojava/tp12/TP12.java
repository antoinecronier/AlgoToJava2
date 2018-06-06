package com.tactfactory.algotojava.tp12;

import com.tactfactory.algotojava.tp12.utils.Conjugateur;

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
