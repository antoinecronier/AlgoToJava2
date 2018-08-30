package com.tactfactory.algotojava.tp17.model;

public class ArmurePhysique extends Armure {
	public static final String TYPE = "physique";

	public ArmurePhysique() {
	}

	public ArmurePhysique(int defense) {
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

}
