package com.tactfactory.algotojava.TP18.model;

public abstract class Contenu {

	private int poids;

	public Contenu(int poids) {
		this.poids = poids;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}
}
