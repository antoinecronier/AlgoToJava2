package com.tactfactory.algotojava.tp17.model;

public class ArmureMagique extends Armure {

	public ArmureMagique() {
	}

	public ArmureMagique(int defense) {
		super(defense);
	}

	@Override
	public int receiveAttack(Arme arme) {
		return 0;
	}

}
