package com.tactfactory.algotojava.tp17.model;

public abstract class Armure implements Butin, Statable {

	protected static final String STATS = "%d defense %s";
	
	private int defense;

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public Armure() {
	}
	
	public Armure(int defense) {
		this.defense = defense;
	}

	public abstract int receiveAttack(Arme arme);
}
