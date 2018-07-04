package com.tactfactory.algotojava.tp18bis.model;

public class Pique implements Family {

	@Override
	public String getRepresentation() {
		StringBuilder card = new StringBuilder();
		card.append(" _____ ");
		card.append("\n");
		card.append("|%s.  |");
		card.append("\n");
		card.append("| /.\\ |");
		card.append("\n");
		card.append("|(_._)|");
		card.append("\n");
		card.append("|  |  |");
		card.append("\n");
		card.append("|___%s|");
		card.append("\n");
		return card.toString();
	}

}
