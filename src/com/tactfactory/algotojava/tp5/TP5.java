package com.tactfactory.algotojava.tp5;

import java.util.Scanner;

/**
 * 
 * @author tactfactory
 *
 * 	- Sur la base du TP4 modifier l’algorithme en utilisant SI SINON SI SINON
 *	- Faire en sorte que l’algorithme retourne toujours une valeur
 *	- L’ordre d’importance des opérations à réaliser est l’ordre des points du
 *		TP4
 *
 */
public class TP5 {

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

		else if (nb1 < 0 && nb2 >= 0) {
			System.out.println("Porduit nb1 et nb2 = " + nb1 * nb2);
		}

		else if (((nb1 >= 0 && nb2 >= 0) || (nb1 < 0 && nb2 < 0)) && ((nb1 > 10 || nb1 < 10) || (nb2 > 10 || nb2 < 10))) {
			if (nb2 == 0) {
				System.out.println("Division par 0");
			} else {
				System.out.println("Division nb1 et nb2 = " + nb1 / nb2);
			}
		}
		
		sc.close();
	}

}
