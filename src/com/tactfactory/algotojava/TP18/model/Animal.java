package com.tactfactory.algotojava.TP18.model;

public class Animal extends Contenu implements MarchandiseAnimal {

	private String race;

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public Animal(String race, int poids) {
		super(poids);
		this.race = race;
	}
}
