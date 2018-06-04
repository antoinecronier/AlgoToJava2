package com.tactfactory.algotojava.tp9.model;

public class Personnage {
	private int vie;
	private int action;
	private Arme arme;
	private Armure armure;
	private String nom;
	
	public int getVie() {
		return vie;
	}
	
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	public int getAction() {
		return action;
	}
	
	public void setAction(int action) {
		this.action = action;
	}
	
	public Arme getArme() {
		return arme;
	}
	
	public void setArme(Arme arme) {
		this.arme = arme;
	}
	
	public Armure getArmure() {
		return armure;
	}
	
	public void setArmure(Armure armure) {
		this.armure = armure;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Personnage(int vie, int action, Arme arme, Armure armure, String nom) {
		super();
		this.vie = vie;
		this.action = action;
		this.arme = arme;
		this.armure = armure;
		this.nom = nom;
	}
	
	public Personnage() {
		
	}
}
