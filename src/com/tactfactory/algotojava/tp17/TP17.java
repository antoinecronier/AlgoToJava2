package com.tactfactory.algotojava.tp17;

import java.util.ArrayList;

import com.tactfactory.algotojava.tp17.manager.Combat;
import com.tactfactory.algotojava.tp17.model.ArmeMagique;
import com.tactfactory.algotojava.tp17.model.ArmeMixte;
import com.tactfactory.algotojava.tp17.model.ArmePhysique;
import com.tactfactory.algotojava.tp17.model.ArmureMagique;
import com.tactfactory.algotojava.tp17.model.ArmureMixte;
import com.tactfactory.algotojava.tp17.model.ArmurePhysique;
import com.tactfactory.algotojava.tp17.model.Hero;
import com.tactfactory.algotojava.tp17.model.Mob;
import com.tactfactory.algotojava.tp17.model.Personnage;
import com.tactfactory.algotojava.tp17.model.rpg.Barbare;
import com.tactfactory.algotojava.tp17.model.rpg.defaultclasse.DefaultBarbare;
import com.tactfactory.algotojava.tp17.model.rpg.defaultclasse.DefaultFighter;
import com.tactfactory.algotojava.tp17.model.rpg.defaultclasse.DefaultMage;
import com.tactfactory.algotojava.tp17.model.rpg.defaultclasse.DefaultPaladin;

public class TP17 {

	public static void main(String[] args) {
		Personnage paladin = new Hero(new DefaultPaladin());
		paladin.getClasse().setPersonnage(paladin);
		
		paladin.setActionPoint(10);
		paladin.setLife(23);
		paladin.setName("jean paladin");

		paladin.setArme(new ArmeMagique(2, 3));
		paladin.setArmure(new ArmureMagique(2));
		
		Personnage barbare = new Hero(new DefaultBarbare());
		barbare.getClasse().setPersonnage(barbare);
		
		barbare.setActionPoint(10);
		barbare.setLife(23);
		barbare.setName("jean barbare");

		barbare.setArme(new ArmePhysique(2, 3));
		((Barbare)barbare.getClasse()).setSecondaryWeapon(new ArmePhysique(3, 2));
		barbare.setArmure(new ArmurePhysique(2));
		
		Personnage mage = new Hero(new DefaultMage());
		mage.getClasse().setPersonnage(mage);
		
		mage.setActionPoint(10);
		mage.setLife(23);
		mage.setName("jean mage");

		mage.setArme(new ArmeMagique(2, 3));
		mage.setArmure(new ArmureMagique(2));

		Personnage mob1 = new Mob(new DefaultFighter());
		mob1.getClasse().setPersonnage(mob1);
		
		mob1.setActionPoint(10);
		mob1.setLife(23);
		mob1.setName("jean mob");

		mob1.setArme(new ArmePhysique(3, 1));
		mob1.setArmure(new ArmurePhysique(2));
		
		Personnage mob2 = new Mob(new DefaultFighter());
		mob2.getClasse().setPersonnage(mob2);
		
		mob2.setActionPoint(10);
		mob2.setLife(23);
		mob2.setName("jean mob2");

		mob2.setArme(new ArmePhysique(3, 1));
		mob2.setArmure(new ArmurePhysique(2));
		
		Personnage mob3 = new Mob(new DefaultFighter());
		mob3.getClasse().setPersonnage(mob3);
		
		mob3.setActionPoint(10);
		mob3.setLife(23);
		mob3.setName("jean mobi");

		mob3.setArme(new ArmePhysique(3, 1));
		mob3.setArmure(new ArmurePhysique(2));
		
		Combat combat = new Combat(new ArrayList<Personnage>() {
			{
				add(paladin);
				add(barbare);
				add(mage);
			}
		}, new ArrayList<Personnage>() {
			{
				add(mob1);
				add(mob2);
				add(mob3);
			}
		});
		combat.fightNoBack();
	}

}
