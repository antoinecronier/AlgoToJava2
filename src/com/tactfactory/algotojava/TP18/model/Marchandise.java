package com.tactfactory.algotojava.TP18.model;

public class Marchandise extends Contenu implements MarchandiseAnimal {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Marchandise(String name, int poids) {
		super(poids);
		this.name = name;
	}

}
