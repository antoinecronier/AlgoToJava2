package com.tactfactory.algotojava.moodle.tp15.model.rpg.defaultclasse;

import com.tactfactory.algotojava.moodle.tp15.model.Arme;
import com.tactfactory.algotojava.moodle.tp15.model.Armure;
import com.tactfactory.algotojava.moodle.tp15.model.Personnage;
import com.tactfactory.algotojava.moodle.tp15.model.rpg.Classe;

public class DefaultFighter implements Classe {
  private static final String RESTRICTION = "sans restriction";

  private Personnage personnage;

  public Personnage getPersonnage() {
    return personnage;
  }

  public void setPersonnage(Personnage personnage) {
    this.personnage = personnage;
  }

  @Override
  public void fight(Personnage defender) {
    if (this.getPersonnage().getCharacteristic().getLife() > 0) {
      int damage = this.getPersonnage().getArme().attack(defender.getArmure());
      defender.getCharacteristic().setLife(defender.getCharacteristic().getLife() - damage);
      System.out.println(String.format(Classe.ATTACK, this.getPersonnage().getName(), damage, defender.getName(), defender.getCharacteristic().getLife()));
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
