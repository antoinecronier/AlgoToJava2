package com.tactfactory.algotojava.tp11.model;

public class Case {

	private int x;
	private int y;
	private boolean touche;
	private Navire navire;
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isTouche() {
		return touche;
	}

	public void setTouche(boolean touche) {
		this.touche = touche;
	}

	public Navire getNavire() {
		return navire;
	}
	
	public void setNavire(Navire navire) {
		this.navire = navire;
		this.navire.getCases().add(this);
	}
	
	public Case(int x, int y){
		this.x = x;
		this.y = y;
	}
}
