package com.tactfactory.algotojava.moodle.tp15.model;

public class ArmureMagique extends Armure {
  public static final String TYPE = "magique";

  public ArmureMagique() {
  }

  public ArmureMagique(int defense) {
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
    return "Armure magique " + super.getName();
  }
}
