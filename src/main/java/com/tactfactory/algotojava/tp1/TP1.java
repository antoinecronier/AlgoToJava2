package com.tactfactory.algotojava.tp1;

import java.util.Scanner;

/**
 * @author tactfactory
 *
 *	- On souhaite déverrouiller un cadenas à code numérique disposant d’une molette
 *	- L'utilisateur ne peut indiquer que "+" ou "-" dans la console pour augmenter ou diminuer la valeur courante du numéro
 *	- Quand le numéro est trouvé on passe directement au suivant
 *	- Si le code ne contient le même nombre sur des indices qui se suivent (1:1:1:1) alors tout les même élément seront déverrouillé en même temps et on cherchera le prochain différent
 *  - La séquence à trouver doit être stocké dans un tableau à une dimension
 *  - Votre programme doit fonctionner peut importe la taille du tableau (1 élément minimum, N élément maximum)
 *
 */
public class TP1 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Série de nombre a trouver
    //int[] cadena = {12,9,14,8};
    int[] cadena = {1,1,1,1};

    // Boucle pour sélectionner le numéro courant a chercher
    int loop = 0;

    // On n'a pas encore résolu la séquence
    boolean notOpened = true;

    // Numéro courant de l'utilisateur
    int userRealNumber = 0;

    // Valeur saisi par l'utilisateur
    String userInput = "";

    // Sens de recherche
    boolean toRight = false;

    System.out.println("Déverouiller le cadenas en bougeant la molette");

    // Tant que l'on n'a pas fini
    while (notOpened) {

      // Tant que l'on n'a pas fini et que l'on a pas trouvé le dernier élément
      // et le numéro courant a trouvé n'est pas bon
      while(notOpened && loop < cadena.length && cadena[loop] != userRealNumber) {

        do {
          System.out.println("Incrémenter '+', décrémenter '-'");
          userInput = scanner.nextLine();
        } while (!userInput.equals("+") && !userInput.equals("-"));

        // Test la direction à prendre.
        if (loop != 0) {
          toRight = (cadena[loop-1] - cadena[loop]) < 0;
        }else {
          toRight = (0 - cadena[loop]) < 0;
        }

        // Test de la saisie utilisateur
        switch (userInput) {
        case "+":
          // Si le déplacement doit aller vers la gauche alors + est faux.
          if (!toRight == true) {
            // On retourne a rechercher le premier élément
            loop = 0;
            // Le nombre de l'utilisateur repart à 0
            userRealNumber = 0;
          }

          // On incrémente le nombre de l'utilisateur
          userRealNumber++;
          break;

        case "-":
          // Si le déplacement doit aller vers la droite alors - est faux
          if (toRight == true) {
            // On retourne a rechercher le premier élément
            loop = 0;
            // Le nombre de l'utilisateur repart à 0
            userRealNumber = 0;
          }
          // On décrémente le nombre de l'utilisateur
          userRealNumber--;
          break;
        }
      }
      // Un numéro est trouvé on passe au prochain
      loop++;

      // Si on a tout trouvé on arrête
      if (loop == cadena.length
          && userRealNumber == cadena[cadena.length-1]) {
        notOpened = false;
      }
    }

    System.out.println("Cadena dévérouillé");

    scanner.close();
  }

}
