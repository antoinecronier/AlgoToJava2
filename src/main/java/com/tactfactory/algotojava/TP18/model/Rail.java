package com.tactfactory.algotojava.TP18.model;

public class Rail {

	private TypeRail typeDeRail;
	private boolean reparation;
	
	public TypeRail getTypeDeRail() {
		return typeDeRail;
	}
	
	public void setTypeDeRail(TypeRail typeDeRail) {
		this.typeDeRail = typeDeRail;
	}
	
	public boolean isReparation() {
		return reparation;
	}
	
	public void setReparation(boolean reparation) {
		this.reparation = reparation;
	}
	
	public Rail(TypeRail typeDeRail) {
		this(typeDeRail,false);
	}

	public Rail(TypeRail typeDeRail, boolean reparation) {
		super();
		this.typeDeRail = typeDeRail;
		this.reparation = reparation;
	}
}
