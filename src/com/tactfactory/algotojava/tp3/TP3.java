package com.tactfactory.algotojava.tp3;

import java.util.Scanner;

/**
 * 
 * @author tactfactory
 *
 * 	- Sur la base du TP2 modifier votre algorithme pour permettre à Jasmine et
 *		Aladin d’avoir le nombre de pomme qu’ils veulent dans leurs panier
 *	- Afficher à l’utilisateur le nombre de pomme contenu dans le panier ou ils
 *		ont mis en commun leurs pommes
 *
 */
public class TP3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int aladin = 0;
		int jasmine = 0;
		
		do {
			System.out.println("Donner des pommes a jasmine");
			jasmine = sc.nextInt();
		} while (jasmine < 0);
		
		do {
			System.out.println("Donner des pommes a aladin");
			aladin = sc.nextInt();
		} while (aladin < 0);
		
		int panierCommun = aladin + jasmine;
		
		System.out.println("Jasmine a " + jasmine + " pommes aladin a " 
				+ aladin + " pommes et leur panier commun contient " 
				+ panierCommun + " pommes.");
		
		sc.close();
	}

}
