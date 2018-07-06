package com.tactfactory.algotojava.TP18.model;

public class Passager extends Contenu {

	private String nom;
	private String prenom;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Passager(String nom, String prenom, int poids) {
		super(poids);
		this.nom = nom;
		this.prenom = prenom;
	}

}
