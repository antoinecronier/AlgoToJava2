package com.tactfactory.algotojava.tp17.model.rpg.defaultclasse;

import com.tactfactory.algotojava.tp17.model.Personnage;
import com.tactfactory.algotojava.tp17.model.rpg.Classe;

public class DefaultFighter implements Classe {

	@Override
	public void fight(Personnage attacker, Personnage defender) {
		if (attacker.getLife() > 0) {
			int damage = attacker.getArme().attack(defender.getArmure());
			defender.setLife(defender.getLife() - damage);
			System.out.println(String.format(Classe.ATTACK, attacker.getName(), damage, defender.getName(), defender.getLife()));
		}
	}

}
