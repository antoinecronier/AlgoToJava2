package com.tactfactory.algotojava.tp17.model;

public class ArmurePhysique extends Armure {

	public ArmurePhysique() {
	}

	public ArmurePhysique(int defense) {
		super(defense);
	}

	@Override
	public int receiveAttack(Arme arme) {
		return 0;
	}

}
