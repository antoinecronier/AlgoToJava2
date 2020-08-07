package com.tactfactory.algotojava.moodle.tp15.model;

public class ArmeMagique extends Arme {

  public final static String TYPE = "magique";

  public ArmeMagique() {
  }

  public ArmeMagique(int degat, int actionPoint) {
    super(degat, actionPoint);
  }

  @Override
  public String getStats() {
    return String.format(STATS, getDegat(), TYPE);
  }

  @Override
  public int attack(Armure armure) {
    int result = 0;

    if (armure instanceof ArmureMagique) {
      result = this.getDegat() - armure.getDefense();
    }else if(armure instanceof ArmureMixte){
      result = this.getDegat() - ((ArmureMixte)armure).getArmureMagique().getDefense();
    }else{
      result = this.getDegat();
    }

    return result > 0 ? result : 0;
  }

  @Override
  public String getName() {
    return "Arme magique " + super.getName();
  }
}
