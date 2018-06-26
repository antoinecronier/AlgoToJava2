package com.tactfactory.algotojava.tp17.model;

public abstract class Arme implements Butin {
	private int degat;

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}
	
	public abstract int attack(Armure armure);
}
