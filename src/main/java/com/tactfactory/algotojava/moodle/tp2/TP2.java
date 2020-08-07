package com.tactfactory.algotojava.moodle.tp2;

/**
*
* @author tactfactory
*
*   - Un carré est définit par quatre côté égaux
*   - Choisir la taille d'un côté
*   - Rendre tout les autres côté  égaux
*   - Calculer le périmètre du carré
*   - Calculer et afficher l'aire du carré
*   - Transformer votre carré en rectangle
*   - Calculer le périmètre du rectangle
*   - Calculer et afficher l'aire du rectangle
*
*/
public class TP2 {

  public static void main(String[] args) {
    int c1, c2, c3, c4;
    c1 = c2 = c3 = c4 = 4;

    int p = c1*4;
    System.out.println(p);
    int a = (int) Math.pow(c1,2);
    System.out.println(a);

    c1 = c3 = 6;
    p = (c1 + c2) * 2;
    System.out.println(p);
    a = c1 * c2;
    System.out.println(a);

  }

}
