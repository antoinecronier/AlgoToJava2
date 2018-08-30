package com.tactfactory.algotojava.tp7;

import java.util.Scanner;

/**
 * 
 * @author tactfactory
 *
 *	- Une machine a café propose une liste de sélection avec des indices de 1 à 8
 *	- Vous devez réaliser un algo qui selon la sélection de l’utilisateur effectuera
 *		les tâches suivantes
 *	-Sélection du bac de grain de café à utiliser (4 bacs)
 *		pour sélection indice 1 à 4 bac 1, indice 5 à 6 bac 2, indice 7 bac 3,
 *		indice 8 bac 4
 *	-Moudre le grain(2 concasseur)
 *		pour les bacs 1 et 2 concasseur 1, bac 3 concasseur 2
 *	-Verser 10 unités de grain moulu pour les indices 1, 3,4, 6
 *	-Verser 25 unités de grain moulu pour les indices 2, 5,7
 *	-Verser 12 unités du bac 4 pour l’indice 8
 *
 */
public class TP7 {

	public static void main(String[] args) {
		String GENERAL_OK = "Café servie dans le bac %d pour %d unité %s";
		String CONCASSE = "et passé dans le concasseur %d";
		String BAC = "Il reste %d unité dans le bac %d";
		String CONCASSEUR = "Le concasseur %d a été utilisé %d fois";
		
		int[][] indiceLinks = {
				{10,1,1},
				{25,1,1},
				{10,1,1},
				{10,1,1},
				{25,2,1},
				{10,2,1},
				{25,3,2},
				{12,4,0}
		};
		
		int[][] items = {
				{100,100,100,100},
				{0  ,0          }
		};
		
		Scanner sc = new Scanner(System.in);
		
		int selection;
		
		while(true) {
			do {
				System.out.println("Selectionner un produit 1 -> 8");
				selection = sc.nextInt();
			} while (selection < 1 || selection > 8);

			// Bac
			if (items[0][indiceLinks[selection - 1][1]-1] - indiceLinks[selection - 1][0] >= 0) {
				items[0][indiceLinks[selection - 1][1]-1] -= indiceLinks[selection - 1][0];
				if (indiceLinks[selection - 1][2] != 0) {
					items[1][indiceLinks[selection - 1][2]-1] ++;
					System.out.println(String.format(GENERAL_OK, indiceLinks[selection - 1][1],indiceLinks[selection - 1][0],String.format(CONCASSE, indiceLinks[selection - 1][2])));
				}else{
					System.out.println(String.format(GENERAL_OK, indiceLinks[selection - 1][1],indiceLinks[selection - 1][0],""));
				}
			}else {
				System.out.println("Plus assez de grain dans le bac " + indiceLinks[selection - 1][1]);
			}
		}
		
		//sc.close();
	}
}
