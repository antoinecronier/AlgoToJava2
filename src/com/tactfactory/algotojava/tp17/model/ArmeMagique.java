package com.tactfactory.algotojava.tp17.model;

public class ArmeMagique extends Arme {
	
	public final static String TYPE = "magique";

	public ArmeMagique() {
	}

	public ArmeMagique(int degat, int actionPoint) {
		super(degat, actionPoint);
	}

	@Override
	public String getStats() {
		return String.format(STATS, getDegat(), TYPE);
	}

}
