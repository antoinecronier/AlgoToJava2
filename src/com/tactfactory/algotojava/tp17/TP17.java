package com.tactfactory.algotojava.tp17;

import java.util.ArrayList;

import com.tactfactory.algotojava.tp17.manager.Combat;
import com.tactfactory.algotojava.tp17.manager.PersonnageBuilder;
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
		PersonnageBuilder builder = new PersonnageBuilder();

		Personnage paladin = builder.setName("paladin").setDefaultHero(new DefaultPaladin()).build();
		builder = new PersonnageBuilder();

		Personnage barbare = builder.setName("barbare").setDefaultHero(new DefaultBarbare()).build();
		((Barbare) barbare.getClasse()).setSecondaryWeapon(new ArmePhysique(3, 2));
		builder = new PersonnageBuilder();

		Personnage mage = builder.setName("mage").setDefaultHero(new DefaultMage()).build();
		builder = new PersonnageBuilder();

		Personnage mob1 = builder.setName("mob1").build();
		builder = new PersonnageBuilder();

		Personnage mob2 = builder.setName("mob2").build();
		builder = new PersonnageBuilder();

		Personnage mob3 = builder.setName("mob3").build();
		builder = new PersonnageBuilder();

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
