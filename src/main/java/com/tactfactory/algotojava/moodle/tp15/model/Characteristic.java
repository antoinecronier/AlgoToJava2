package com.tactfactory.algotojava.moodle.tp15.model;

public class Characteristic {
  private int life;
  private int actionPoint;
  private int currentActionPoint;

  public int getLife() {
    return life;
  }

  public void setLife(int life) {
    this.life = life;
  }

  public int getActionPoint() {
    return actionPoint;
  }

  public void setActionPoint(int actionPoint) {
    this.actionPoint = actionPoint;
  }

  public int getCurrentActionPoint() {
    return currentActionPoint;
  }

  public void setCurrentActionPoint(int currentActionPoint) {
    this.currentActionPoint = currentActionPoint;
  }

  public Characteristic() {
  }

  public Characteristic(int life, int actionPoint) {
    super();
    this.life = life;
    this.actionPoint = actionPoint;
    this.currentActionPoint = actionPoint;
  }
}
