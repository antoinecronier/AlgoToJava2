package com.tactfactory.algotojava.tp4;

import java.util.Scanner;

/**
 * 
 * @author tactfactory
 *
 *         - Vous devez créer un programme de calcul qui demande à un
 *         utilisateur de saisir 2 chiffres entiers -Si les 2 chiffres sont
 *         identique le programme retourne la somme des 2 chiffres - Si le
 *         premier nombre saisi est négatif et le deuxième est positif on
 *         retourne le produit des 2 chiffres -Si les 2 chiffres sont positif ou
 *         négatif et qu’un des chiffres est supérieur à 10 ou inférieur à -10
 *         on retourne la division des 2 chiffres
 *
 */
public class TP4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int nb1 = 0;
		int nb2 = 0;

		System.out.println("Choisir nombre 1");
		nb1 = sc.nextInt();

		System.out.println("Choisir nombre 2");
		nb2 = sc.nextInt();

		if (nb1 == nb2) {
			System.out.println("Somme nb1 et nb2 = " + (nb1 + nb2));
		}

		if (nb1 < 0 && nb2 >= 0) {
			System.out.println("Porduit nb1 et nb2 = " + nb1 * nb2);
		}

		if (((nb1 >= 0 && nb2 >= 0) || (nb1 < 0 && nb2 < 0)) 
				&& ((nb1 > 10 || nb1 < -10) || (nb2 > 10 || nb2 < -10))) {
			if (nb2 == 0) {
				System.out.println("Division par 0");
			} else {
				System.out.println("Division nb1 et nb2 = " + nb1 / (double)nb2);
			}
		}
		
		sc.close();
	}
}
