package com.tactfactory.algotojava.tp17.model.rpg.defaultclasse;

import com.tactfactory.algotojava.tp17.model.Arme;
import com.tactfactory.algotojava.tp17.model.ArmeMagique;
import com.tactfactory.algotojava.tp17.model.Armure;
import com.tactfactory.algotojava.tp17.model.ArmureMagique;
import com.tactfactory.algotojava.tp17.model.Personnage;
import com.tactfactory.algotojava.tp17.model.rpg.Classe;
import com.tactfactory.algotojava.tp17.model.rpg.Mage;

public class DefaultMage extends DefaultFighter implements Mage {

	@Override
	public boolean isEquipable(Arme arme) {
		boolean result = false;
		if (arme instanceof ArmeMagique) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		boolean result = false;
		if (armure instanceof ArmureMagique) {
			result = true;
		}
		return result;
	}
	
	@Override
	public String getArmorRestriction() {
		return String.format(Classe.EQUIPARMOR, Mage.CLASSE, Mage.EQUIPARMOR);
	}

	@Override
	public String getWeaponRestriction() {
		return String.format(Classe.EQUIPWEAPON, Mage.CLASSE, Mage.EQUIPWEAPON);
	}
}
