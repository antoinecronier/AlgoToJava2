package com.tactfactory.algotojava.TP18.model;

import java.util.ArrayList;
import java.util.List;

public class Train {

	private String name;
	private Trajet trajet;
	private List<Wagon> wagons;
	private MachineDeTete machineDeTete;
	private TypeRail typeRail;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Trajet getTrajet() {
		return trajet;
	}
	
	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
	
	public List<Wagon> getWagons() {
		return wagons;
	}
	
	public void setWagons(List<Wagon> wagons) {
		this.wagons = wagons;
	}
	
	public MachineDeTete getMachineDeTete() {
		return machineDeTete;
	}
	
	public void setMachineDeTete(MachineDeTete machineDeTete) {
		this.machineDeTete = machineDeTete;
	}
	
	public TypeRail getTypeRail() {
		return typeRail;
	}
	
	public void setTypeRail(TypeRail typeRail) {
		this.typeRail = typeRail;
	}

	public Train(String name, Trajet trajet, List<Wagon> wagons, MachineDeTete machineDeTete, TypeRail typeRail) {
		super();
		this.name = name;
		this.trajet = trajet;
		this.wagons = wagons;
		this.machineDeTete = machineDeTete;
		this.typeRail = typeRail;
	}
	
	public Train(){
		this.wagons = new ArrayList<Wagon>();
	}
	
	public Integer getVitesseReel() {
		int result = 0;
		int baseVitesse = machineDeTete.getVitesseMax();
		int acceleration = (getPoidsReel()-machineDeTete.getPoidsTractable())/100;///1000;
		result = baseVitesse - acceleration;
		if (result <= 0) {
			result = 0;
		}
		return result;
	}
	
	public int getPoidsReel() {
		int result = 0;
		for (Wagon wagon : wagons) {
			result += wagon.getPoids();
			for (Contenu contenu : wagon.contenus) {
				result += contenu.getPoids();
			}
		}
		result += machineDeTete.getPoids();
		return result;
	}
}
