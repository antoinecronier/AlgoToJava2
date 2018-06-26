package com.tactfactory.algotojava.tp17.model.rpg;

import com.tactfactory.algotojava.tp17.model.Personnage;

public interface Classe {
	final static String ATTACK = "Le personnage %s infligre %d point de degats au personnage %s, il lui reste %d pv";
	
	void fight(Personnage attacker, Personnage defender);
}
