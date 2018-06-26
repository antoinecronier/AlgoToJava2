package com.tactfactory.algotojava.tp17;

import com.tactfactory.algotojava.tp17.model.ArmeMagique;
import com.tactfactory.algotojava.tp17.model.ArmeMixte;
import com.tactfactory.algotojava.tp17.model.ArmePhysique;
import com.tactfactory.algotojava.tp17.model.ArmureMagique;
import com.tactfactory.algotojava.tp17.model.ArmureMixte;
import com.tactfactory.algotojava.tp17.model.ArmurePhysique;
import com.tactfactory.algotojava.tp17.model.Hero;
import com.tactfactory.algotojava.tp17.model.Mob;
import com.tactfactory.algotojava.tp17.model.Personnage;
import com.tactfactory.algotojava.tp17.model.rpg.defaultclasse.DefaultFighter;
import com.tactfactory.algotojava.tp17.model.rpg.defaultclasse.DefaultPaladin;

public class TP17 {

	public static void main(String[] args) {
		Personnage paladin = new Hero(new DefaultPaladin());
		Personnage mob1 = new Mob(new DefaultFighter());
		
		paladin.setArme(new ArmeMixte(new ArmePhysique(2, 1), new ArmeMagique(3, 1)));
		paladin.setArmure(new ArmureMixte(new ArmureMagique(1), new ArmurePhysique(3)));
		
		paladin.setActionPoint(10);
		paladin.setLife(23);
		paladin.setName("jean paladin");
		
		mob1.setArme(new ArmePhysique(3,1));
		mob1.setArmure(new ArmurePhysique(2));
		
		mob1.setActionPoint(10);
		mob1.setLife(23);
		mob1.setName("jean mob");
		
		paladin.getClasse().fight(paladin,mob1);
		mob1.getClasse().fight(mob1,paladin);
	}

}
