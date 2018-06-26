package com.tactfactory.algotojava.tp17.model.rpg;

import com.tactfactory.algotojava.tp17.model.Arme;
import com.tactfactory.algotojava.tp17.model.Armure;
import com.tactfactory.algotojava.tp17.model.Personnage;

public interface Classe {
	public final static String ATTACK = "Le personnage %s infligre %d point de degats au personnage %s, il lui reste %d pv";
	public final static String EQUIPWEAPON = "Un %s ne peut pas s'equiper d'une arme autre que %s";
	public final static String EQUIPARMOR = "Un %s ne peut pas s'equiper d'une armure autre que %s";
	public final static String CLASSE = "classe";
	
	String getArmorRestriction();
	
	String getWeaponRestriction();
	
	void fight(Personnage attacker, Personnage defender);

	boolean isEquipable(Arme arme);

	boolean isEquipable(Armure armure);
}
