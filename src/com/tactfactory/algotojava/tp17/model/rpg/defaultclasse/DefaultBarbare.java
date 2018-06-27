package com.tactfactory.algotojava.tp17.model.rpg.defaultclasse;

import com.tactfactory.algotojava.tp17.model.Arme;
import com.tactfactory.algotojava.tp17.model.ArmePhysique;
import com.tactfactory.algotojava.tp17.model.Armure;
import com.tactfactory.algotojava.tp17.model.ArmurePhysique;
import com.tactfactory.algotojava.tp17.model.Personnage;
import com.tactfactory.algotojava.tp17.model.rpg.Barbare;
import com.tactfactory.algotojava.tp17.model.rpg.Classe;

public class DefaultBarbare extends DefaultFighter implements Barbare {

	private final static String EQUIPWEAPON = "%s s'equipe d'une arme %s avec %s";
	
	private Arme secondaryWeapon;

	@Override
	public void setSecondaryWeapon(Arme secondaryWeapon) {
		if (this.isEquipable(secondaryWeapon)) {
			this.secondaryWeapon = secondaryWeapon;
			this.getPersonnage().getArme().setRealActionPoint((this.getPersonnage().getArme().getActionPoint()+this.getSecondaryWeapon().getDegat())/2);
			System.out.println(String.format(EQUIPWEAPON,this.getPersonnage().getName(), secondaryWeapon.getClass().getSimpleName(),secondaryWeapon.getStats()));
		}else{
			System.out.println(this.getWeaponRestriction());
		}
	}

	@Override
	public Arme getSecondaryWeapon() {
		return this.secondaryWeapon;
	}
	
	@Override
	public void fight(Personnage defender) {
		if (this.getPersonnage().getCharacteristic().getLife() > 0) {
			int damage = this.getPersonnage().getArme().attack(defender.getArmure()) + this.getSecondaryWeapon().getDegat();
			defender.getCharacteristic().setLife(defender.getCharacteristic().getLife() - damage);
			System.out.println(String.format(Classe.ATTACK, this.getPersonnage().getName(), damage, defender.getName(), defender.getCharacteristic().getLife()));
		}
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
