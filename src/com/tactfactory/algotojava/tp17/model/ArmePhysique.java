package com.tactfactory.algotojava.tp17.model;

public class ArmePhysique extends Arme {
	
	public final static String TYPE = "physique";
	
	public ArmePhysique() {
	}

	public ArmePhysique(int degat, int actionPoint) {
		super(degat, actionPoint);
	}

	@Override
	public String getStats() {
		return String.format(STATS, getDegat(), TYPE);
	}

}
