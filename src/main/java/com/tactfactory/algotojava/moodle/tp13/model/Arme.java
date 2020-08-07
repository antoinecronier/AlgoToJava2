package com.tactfactory.algotojava.moodle.tp13.model;

public class Arme {
  private ArmeType armeType;
  private int action;
  private int dega;

  public ArmeType getArmeType() {
    return armeType;
  }

  public void setArmeType(ArmeType armeType) {
    this.armeType = armeType;
  }

  public int getAction() {
    return action;
  }

  public void setAction(int action) {
    this.action = action;
  }

  public int getDega() {
    return dega;
  }

  public void setDega(int dega) {
    this.dega = dega;
  }

  public Arme(ArmeType armeType) {
    this.armeType = armeType;

    switch (armeType) {
    case Concasseur:
      this.action = 4;
      this.dega = 3;
      break;
    case Pelle:
      this.action = 1;
      this.dega = 2;
      break;
    case Gatling:
      this.action = 6;
      this.dega = 10;
      break;
    case BatteDeCricket:
      this.action = 1;
      this.dega = 1;
      break;
    case Blaster:
      this.action = 3;
      this.dega = 6;
      break;
    }
  }
}
