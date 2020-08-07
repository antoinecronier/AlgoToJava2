package com.tactfactory.algotojava.moodle.tp14;

import com.tactfactory.algotojava.moodle.tp14.manager.Jeu;
import com.tactfactory.algotojava.moodle.tp14.model.Joueur;

public class TP14 {

  public static void main(String[] args) throws CloneNotSupportedException {
    Jeu jeu = new Jeu(2,7,10);

    for (Joueur joueur : jeu.getJoueurs()) {
      jeu.placementBateaux(joueur);
      jeu.afficheMap(joueur);
    }

    jeu.play();

//		jeu = new Jeu(4, new ArrayList<Navire>() {
//			{
//				add(new PorteAvion());
////				add(new Corvette());
////				add(new Corvette());
////				add(new Croiseur());
////				add(new Croiseur());
////				add(new Croiseur());
////				add(new Destroyer());
////				add(new Destroyer());
//			}
//		});
//		jeu.play();
  }
}
