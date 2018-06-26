package com.tactfactory.algotojava.tp17.model.rpg.defaultclasse;

import com.tactfactory.algotojava.tp17.model.Arme;
import com.tactfactory.algotojava.tp17.model.Armure;
import com.tactfactory.algotojava.tp17.model.Personnage;
import com.tactfactory.algotojava.tp17.model.rpg.Classe;

public class DefaultFighter implements Classe {
	private static final String RESTRICTION = "sans restriction";

	@Override
	public void fight(Personnage attacker, Personnage defender) {
		if (attacker.getLife() > 0) {
			int damage = attacker.getArme().attack(defender.getArmure());
			defender.setLife(defender.getLife() - damage);
			System.out.println(String.format(Classe.ATTACK, attacker.getName(), damage, defender.getName(), defender.getLife()));
		}
	}

	@Override
	public boolean isEquipable(Arme arme) {
		return true;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		return true;
	}

	@Override
	public String getArmorRestriction() {
		return RESTRICTION;
	}

	@Override
	public String getWeaponRestriction() {
		return RESTRICTION;
	}

}
