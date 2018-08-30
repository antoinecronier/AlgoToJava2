package com.tactfactory.algotojava.TP18.model;

import java.util.Date;

public class Trajet {

	private Gare gareDepart;
	private Gare gareArrive;
	private Date depart;
	private Date arrive;
	private Rail rail;
	
	public Gare getGareDepart() {
		return gareDepart;
	}
	
	public void setGareDepart(Gare gareDepart) {
		this.gareDepart = gareDepart;
	}
	
	public Gare getGareArrive() {
		return gareArrive;
	}
	
	public void setGareArrive(Gare gareArrive) {
		this.gareArrive = gareArrive;
	}
	
	public Date getDepart() {
		return depart;
	}
	
	public void setDepart(Date depart) {
		this.depart = depart;
	}
	
	public Date getArrive() {
		return arrive;
	}
	
	public void setArrive(Date arrive) {
		this.arrive = arrive;
	}

	public Rail getRail() {
		return rail;
	}

	public void setRail(Rail rail) {
		this.rail = rail;
	}

	public Trajet(Gare gareDepart, Gare gareArrive, Date depart, Date arrive, Rail rail) {
		super();
		this.gareDepart = gareDepart;
		this.gareArrive = gareArrive;
		this.depart = depart;
		this.arrive = arrive;
		this.rail = rail;
	}
}
