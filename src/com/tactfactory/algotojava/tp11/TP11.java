package com.tactfactory.algotojava.tp11;

import java.util.ArrayList;

import com.tactfactory.algotojava.tp11.manager.Jeu;
import com.tactfactory.algotojava.tp11.model.Corvette;
import com.tactfactory.algotojava.tp11.model.Croiseur;
import com.tactfactory.algotojava.tp11.model.Destroyer;
import com.tactfactory.algotojava.tp11.model.Navire;
import com.tactfactory.algotojava.tp11.model.PorteAvion;

public class TP11 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Jeu jeu = new Jeu(2);
		//jeu.play();
		
		jeu = new Jeu(4, new ArrayList<Navire>() {
			{
				add(new PorteAvion());
//				add(new Corvette());
//				add(new Corvette());
//				add(new Croiseur());
//				add(new Croiseur());
//				add(new Croiseur());
//				add(new Destroyer());
//				add(new Destroyer());
			}
		});
		jeu.play();
	}
}
