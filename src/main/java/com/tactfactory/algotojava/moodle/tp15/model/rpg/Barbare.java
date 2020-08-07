package com.tactfactory.algotojava.moodle.tp15.model.rpg;

import com.tactfactory.algotojava.moodle.tp15.model.Arme;

public interface Barbare extends Classe {
  public final static String EQUIPWEAPON = "physique";
  public final static String EQUIPARMOR = "physique";
  public final static String CLASSE = "barbare";

  void setSecondaryWeapon(Arme arme);

  Arme getSecondaryWeapon();
}
