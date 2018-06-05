package com.tactfactory.algotojava.tp11.model;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

	List<Navire> map;
	List<Case> tires;
	String nom;

	public List<Navire> getMap() {
		return map;
	}

	public List<Case> getTires() {
		return tires;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Joueur() {
		map = new ArrayList<Navire>();
		tires = new ArrayList<Case>();
	}

	public Joueur(int option, String nom) {
		this();
		this.nom = nom;
		
		switch (option) {
		case 1:
			for (int i = 0; i < 1; i++) {
				this.map.add(new Corvette());
			}
			for (int i = 0; i < 2; i++) {
				this.map.add(new Destroyer());
			}
			for (int i = 0; i < 2; i++) {
				this.map.add(new Croiseur());
			}
			for (int i = 0; i < 1; i++) {
				this.map.add(new PorteAvion());
			}

			break;
		}
	}

	public boolean getVivant() {
		boolean vivant = false;
		for (Navire navire : map) {
			if (navire.getVivant()) {
				vivant = true;
			}
		}
		return vivant;
	}
}
