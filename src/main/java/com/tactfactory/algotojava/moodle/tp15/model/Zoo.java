package com.tactfactory.algotojava.moodle.tp15.model;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
  private String name;
  private List<Cage> cages;
  private List<Animaux> animaux;
  private List<Nourriture> nourriture;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public List<Cage> getCages() {
    return cages;
  }
  public List<Animaux> getAnimaux() {
    return animaux;
  }
  public List<Nourriture> getNourriture() {
    return nourriture;
  }

  public Zoo() {
    this.animaux = new ArrayList<>();
    this.cages = new ArrayList<>();
    this.nourriture = new ArrayList<>();
  }
}
