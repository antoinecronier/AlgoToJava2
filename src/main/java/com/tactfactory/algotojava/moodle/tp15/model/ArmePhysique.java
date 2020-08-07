package com.tactfactory.algotojava.moodle.tp15.model;

public class ArmePhysique extends Arme {

  public final static String TYPE = "physique";

  public ArmePhysique() {
  }

  public ArmePhysique(int degat, int actionPoint) {
    super(degat, actionPoint);
  }

  @Override
  public String getStats() {
    return String.format(STATS, getDegat(), TYPE);
  }

  @Override
  public int attack(Armure armure) {
    int result = 0;

    if (armure instanceof ArmurePhysique) {
      result = this.getDegat() - armure.getDefense();
    }else if(armure instanceof ArmureMixte){
      result = this.getDegat() - ((ArmureMixte)armure).getArmurePhysique().getDefense();
    }else{
      result = this.getDegat();
    }

    return result > 0 ? result : 0;
  }

  @Override
  public String getName() {
    return "Arme physique " + super.getName();
  }
}
