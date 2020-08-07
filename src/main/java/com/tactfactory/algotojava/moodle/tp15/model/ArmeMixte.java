package com.tactfactory.algotojava.moodle.tp15.model;

public class ArmeMixte extends Arme {

  private static final String STATS = "%d degat d'attaque %s et %d degat d'attaque %s";

  private ArmePhysique armePhysique;
  private ArmeMagique armeMagique;

  public ArmePhysique getArmePhysique() {
    return armePhysique;
  }

  public void setArmePhysique(ArmePhysique armePhysique) {
    this.armePhysique = armePhysique;
  }

  public ArmeMagique getArmeMagique() {
    return armeMagique;
  }

  public void setArmeMagique(ArmeMagique armeMagique) {
    this.armeMagique = armeMagique;
  }

  public ArmeMixte(ArmePhysique armePhysique, ArmeMagique armeMagique) {
    this.armePhysique = armePhysique;
    this.armeMagique = armeMagique;
  }

  @Override
  public int attack(Armure armure) {
    int result = 0;
    if (armure instanceof ArmureMixte) {
      result = (this.getArmeMagique().getDegat() - ((ArmureMixte)armure).getArmureMagique().getDefense())+
          (this.getArmePhysique().getDegat() - ((ArmureMixte)armure).getArmurePhysique().getDefense());
    }else if (armure instanceof ArmurePhysique) {
      result = (this.getArmeMagique().getDegat())+
          (this.getArmePhysique().getDegat() - armure.getDefense());
    }else if (armure instanceof ArmureMagique) {
      result = (this.getArmeMagique().getDegat() - armure.getDefense())+
          (this.getArmePhysique().getDegat());
    }
    return result > 0 ? result : 0;
  }

  @Override
  public String getStats() {
    return String.format(STATS, this.getArmeMagique().getDegat(), ArmeMagique.TYPE, this.getArmePhysique().getDegat(), ArmePhysique.TYPE);
  }

  @Override
  public String getName() {
    return "Arme mixte " + super.getName();
  }
}
