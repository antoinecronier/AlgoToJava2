package com.tactfactory.algotojava.moodle.tp15.model;

public class ArmurePhysique extends Armure {
  public static final String TYPE = "physique";

  public ArmurePhysique() {
  }

  public ArmurePhysique(int defense) {
    super(defense);
  }

  @Override
  public int receiveAttack(Arme arme) {
    return 0;
  }

  @Override
  public String getStats() {
    return String.format(STATS, getDefense(), TYPE);
  }

  @Override
  public String getName() {
    return "Armure physique " + super.getName();
  }
}
