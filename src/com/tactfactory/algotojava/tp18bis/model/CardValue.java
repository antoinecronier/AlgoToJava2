package com.tactfactory.algotojava.tp18bis.model;

public class CardValue {
	private String representationLeft;
	private String representationRight;
	private int value;
	
	public String getRepresentationLeft() {
		return representationLeft;
	}
	
	public void setRepresentationLeft(String representationLeft) {
		this.representationLeft = representationLeft;
	}
	
	public String getRepresentationRight() {
		return representationRight;
	}

	public void setRepresentationRight(String representationRight) {
		this.representationRight = representationRight;
	}

	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public CardValue(String representationLeft, String representationRight, int value) {
		super();
		this.representationLeft = representationLeft;
		this.representationRight = representationRight;
		this.value = value;
	}
}
