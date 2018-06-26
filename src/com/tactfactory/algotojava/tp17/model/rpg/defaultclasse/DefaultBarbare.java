package com.tactfactory.algotojava.tp17.model.rpg.defaultclasse;

import com.tactfactory.algotojava.tp17.model.Arme;
import com.tactfactory.algotojava.tp17.model.ArmePhysique;
import com.tactfactory.algotojava.tp17.model.Armure;
import com.tactfactory.algotojava.tp17.model.ArmurePhysique;
import com.tactfactory.algotojava.tp17.model.rpg.Barbare;
import com.tactfactory.algotojava.tp17.model.rpg.Classe;

public class DefaultBarbare extends DefaultFighter implements Barbare {

	@Override
	public void setSecondaryWeapon(Arme arme) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Arme getSecondaryWeapon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEquipable(Arme arme) {
		boolean result = false;
		if (arme instanceof ArmePhysique) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isEquipable(Armure armure) {
		boolean result = false;
		if (armure instanceof ArmurePhysique) {
			result = true;
		}
		return result;
	}

	@Override
	public String getArmorRestriction() {
		return String.format(Classe.EQUIPARMOR, Barbare.CLASSE, Barbare.EQUIPARMOR);
	}

	@Override
	public String getWeaponRestriction() {
		return String.format(Classe.EQUIPWEAPON, Barbare.CLASSE, Barbare.EQUIPWEAPON);
	}
}
