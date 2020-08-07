package com.tactfactory.algotojava.moodle.tp13.model;

public class Armure {
  private ArmureType armureType;
  private int armure;

  public ArmureType getArmureType() {
    return armureType;
  }

  public void setArmureType(ArmureType armureType) {
    this.armureType = armureType;
  }

  public int getArmure() {
    return armure;
  }

  public void setArmure(int armure) {
    this.armure = armure;
  }

  public Armure(ArmureType armureType) {
    this.armureType = armureType;

    switch (armureType) {
    case GiletBleu:
      this.armure = 1;
      break;
    case ArmureDeCuir:
      this.armure = 2;
      break;
    case ArmureDePlaque:
      this.armure = 4;
      break;
    }
  }
}
