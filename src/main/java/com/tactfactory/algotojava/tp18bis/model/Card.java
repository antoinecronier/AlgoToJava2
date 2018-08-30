package com.tactfactory.algotojava.tp18bis.model;

import java.util.ArrayList;
import java.util.List;

public class Card implements CardPrintable, Printable {
	
	private CardValue value;
	private Family family;
	
	public CardValue getValue() {
		return value;
	}

	public Family getFamily() {
		return family;
	}

	public Card(CardValue value, Family family) {
		super();
		this.value = value;
		this.family = family;
	}
	
	@Override
	public void print(){
		System.out.println(String.format(family.getRepresentation(), value.getRepresentationLeft(), value.getRepresentationRight()));	
	}

	@Override
	public List<String> printExpression() {
		List<String> result = new ArrayList<String>();
		for (String string : String.format(family.getRepresentation(), value.getRepresentationLeft(), value.getRepresentationRight()).split("\n")) {
			result.add(string);
		}
		return result;
	}
}
