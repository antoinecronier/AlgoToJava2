package com.tactfactory.algotojava.moodle.tp6;

import java.util.Scanner;

/**
*
* @author tactfactory
*
*   - Demander à l'utilisateur de saisir 2 entiers positif plus grand que 0
*   - Afficher un rectangle utilisant ces entiers pour sa taille
*   - Le rectangle sera représenté avec des "*" et il sera plein
*
*/
public class TP6 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int largeur;
    int hauteur;

    do {
      System.out.println("Saisir largeur >= 1");
      largeur = sc.nextInt();
    } while (largeur <= 0);

    do {
      System.out.println("Saisir hauteur >= 1");
      hauteur = sc.nextInt();
    } while (hauteur <= 0);

    for (int i = 0; i < hauteur; i++) {
      for (int j = 0; j < largeur; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    sc.close();
  }
}
