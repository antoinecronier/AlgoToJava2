package com.tactfactory.algotojava.tp3;

import java.util.Scanner;

/**
 *
 * @author tactfactory
 *
 * 	- Sur la base du TP2 modifier votre algorithme pour permettre à Jasmine et Aladin d’avoir le nombre de pomme que l'utilisateur souhaite dans leurs panier
 *	- Aladin donnera la moitié de ses pommes à jasmine en affichant "une pomme" à chaque fois qu'il mettra une pomme dans le panier de jasmine
 *	- Puis ils mettront leurs pommes dans le panier commun en affichant "une pomme de (jasmine|alain)" à chaque fois qu'ils mettront une pomme dans le panier commun
 *	- On affichera le nombre de pomme du panier commun
 *  - Attention l'utilisateur devra toujours assigner un nombre de pomme positif à aladin et jasmine
 *
 */
public class TP3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int aladin = 0;
    int jasmine = 0;
    int panierCommun = 0;

    do {
      System.out.println("Donner des pommes a jasmine");
      jasmine = sc.nextInt();
    } while (jasmine < 0);

    do {
      System.out.println("Donner des pommes a aladin");
      aladin = sc.nextInt();
    } while (aladin < 0);

    int pommeAdonner = aladin/2;
    for (int i = 1; i < pommeAdonner; i++) {
      jasmine++;
      System.out.println("Une pomme");
    }
    aladin -= pommeAdonner;

    for (int i = 1; i < aladin; i++) {
      panierCommun++;
      System.out.println("Une pomme de aladin");
    }

    for (int i = 1; i < aladin; i++) {
      panierCommun++;
      System.out.println("Une pomme de jasmine");
    }

    System.out.println("Jasmine a " + jasmine + " pommes aladin a "
        + aladin + " pommes et leur panier commun contient "
        + panierCommun + " pommes.");

    sc.close();
  }
}
