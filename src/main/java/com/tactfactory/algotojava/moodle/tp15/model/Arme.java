package com.tactfactory.algotojava.moodle.tp15.model;

public abstract class Arme implements Butin, Statable {

  protected static final String STATS = "%d degat d'attaque %s";

  private int degat;
  private int actionPoint;
  private int realActionPoint;

  public int getDegat() {
    return degat;
  }

  public void setDegat(int degat) {
    this.degat = degat;
  }

  public int getActionPoint() {
    return actionPoint;
  }

  public void setActionPoint(int actionPoint) {
    this.actionPoint = actionPoint;
  }

  public int getRealActionPoint() {
    return realActionPoint;
  }

  public void setRealActionPoint(int realActionPoint) {
    this.realActionPoint = realActionPoint;
  }

  public Arme() {
  }

  public Arme(int degat, int actionPoint) {
    this.degat = degat;
    this.actionPoint = actionPoint;
    this.realActionPoint = actionPoint;
  }

  public int attack(Armure armure) {
    int result = 0;

    result = this.getDegat() - armure.getDefense();

    return result > 0 ? result : 0;
  }

  @Override
  public String getName() {
    return this.getStats();
  }
}
