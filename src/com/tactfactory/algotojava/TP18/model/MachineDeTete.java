package com.tactfactory.algotojava.TP18.model;

public class MachineDeTete extends PartieDeTrain {

	private int vitesseMax;
	private int poidsTractable;

	public int getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	public int getPoidsTractable() {
		return poidsTractable;
	}

	public void setPoidsTractable(int poidsTractable) {
		this.poidsTractable = poidsTractable;
	}

	public MachineDeTete(int vitesseMax, int poidsTractable, int poids) {
		super(poids);
		this.vitesseMax = vitesseMax;
		this.poidsTractable = poidsTractable;
	}
}
