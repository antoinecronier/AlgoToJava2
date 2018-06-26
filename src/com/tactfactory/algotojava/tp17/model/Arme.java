package com.tactfactory.algotojava.tp17.model;

public abstract class Arme implements Butin {
	private int degat;
	private int actionPoint;

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}

	public int getActionPoint() {
		return actionPoint;
	}

	public void setActionPoint(int actionPoint) {
		this.actionPoint = actionPoint;
	}

	public Arme() {
	}

	public Arme(int degat, int actionPoint) {
		this.degat = degat;
		this.actionPoint = actionPoint;
	}

	public int attack(Armure armure) {
		int result = 0;

		result = this.getDegat() - armure.getDefense();

		return result > 0 ? result : 0;
	}
}
