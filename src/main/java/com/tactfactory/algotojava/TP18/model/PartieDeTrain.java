package com.tactfactory.algotojava.TP18.model;

public abstract class PartieDeTrain {

	private int poids;

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public PartieDeTrain(int poids) {
		super();
		this.poids = poids;
	}
}
