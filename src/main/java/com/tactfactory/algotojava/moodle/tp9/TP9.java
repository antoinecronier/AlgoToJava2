package com.tactfactory.algotojava.moodle.tp9;

/**
 *
 * @author tactfactory
 *
 *  - Construire un tableau de température à une dimension
 *  - Les températures doivent être comprise entre -273 et 5526
 *  - Vous devez afficher la température la plus proche de 0
 *  - Si le tableau est vide afficher 0
 *  - Si deux éléments sont aussi proche de 0 avec un négatif et un positif afficher le nombre positif
 *
 */
public class TP9 {
  public static void main(String[] args) {
    int[] temperature = { -10, 3, 4, -6, 20, -3, 7 };

    int result = 5527;

    if (temperature.length == 0) {
      result = 0;
    } else {
      for (int i = 0; i < temperature.length; i++) {
        int t = temperature[i];

        if (Math.abs(result) >= Math.abs(t)) {
          if (result > 0 && Math.abs(result) == Math.abs(t)) {
            t = Math.abs(t);
          }
          result = t;
        }
      }
    }

    System.out.println(result);
  }
}
