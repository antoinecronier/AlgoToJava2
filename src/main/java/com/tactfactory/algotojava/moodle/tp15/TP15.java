package com.tactfactory.algotojava.moodle.tp15;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.moodle.tp15.manager.Combat;
import com.tactfactory.algotojava.moodle.tp15.manager.PersonnageBuilder;
import com.tactfactory.algotojava.moodle.tp15.model.ArmePhysique;
import com.tactfactory.algotojava.moodle.tp15.model.Butin;
import com.tactfactory.algotojava.moodle.tp15.model.Personnage;
import com.tactfactory.algotojava.moodle.tp15.model.rpg.Barbare;
import com.tactfactory.algotojava.moodle.tp15.model.rpg.defaultclasse.DefaultBarbare;
import com.tactfactory.algotojava.moodle.tp15.model.rpg.defaultclasse.DefaultMage;
import com.tactfactory.algotojava.moodle.tp15.model.rpg.defaultclasse.DefaultPaladin;

public class TP15 {

  public static void main(String[] args) {
    PersonnageBuilder builder = new PersonnageBuilder();

    Personnage paladin = builder.setName("paladin1").setDefaultHero(new DefaultPaladin()).build();
    builder = new PersonnageBuilder();

    Personnage barbare = builder.setName("barbare1").setDefaultHero(new DefaultBarbare()).build();
    ((Barbare) barbare.getClasse()).setSecondaryWeapon(new ArmePhysique(3, 2));
    builder = new PersonnageBuilder();

    Personnage mage = builder.setName("mage1").setDefaultHero(new DefaultMage()).build();
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
    List<Butin> butins = combat.fightNoBack();

    for (Butin butin : butins) {
      System.out.println(butin.getName());
    }
  }

}
