package com.tactfactory.algotojava.tp2;

/**
 * 
 * @author tactfactory
 *
 * 	- Jasmine et Aladin possèdent tout les deux un panier de pomme
 *	- Jasmine a 7 pommes dans son panier et Aladin 5
 *	- Il regroupe leurs pommes dans un nouveau panier
 *
 */
public class TP2 {

	public static void main(String[] args) {
		int aladin = 5;
		int jasmine = 7;
		
		int panierCommun = aladin + jasmine;
		
		System.out.println("Jasmine a " + jasmine + " pommes aladin a " 
				+ aladin + " pommes et leur panier commun contient " 
				+ panierCommun + " pommes.");
	}

}
