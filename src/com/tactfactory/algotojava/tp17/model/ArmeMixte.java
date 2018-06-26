package com.tactfactory.algotojava.tp17.model;

public class ArmeMixte extends Arme {

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

	@Override
	public int attack(Armure armure) {
		// TODO Auto-generated method stub
		return 0;
	}
}
