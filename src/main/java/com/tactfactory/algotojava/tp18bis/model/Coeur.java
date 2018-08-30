package com.tactfactory.algotojava.tp18bis.model;

public class Coeur implements Family {

	public final static String[][] POKER_DECK = new String[][] { { "A_", "_A", "14" }, { "R_", "_R", "13" },
		{ "D_", "_D", "12" }, { "V_", "_V", "11" }, { "10", "10", "10" }, { "9_", "_9", "9" }, { "8_", "_8", "8" },
		{ "7_", "_7", "7" }, };
		
	@Override
	public String getRepresentation() {
		StringBuilder card = new StringBuilder();
		card.append(" _____ ");
		card.append("\n");
		card.append("|%s _ |");
		card.append("\n");
		card.append("|( v )|");
		card.append("\n");
		card.append("| \\ / |");
		card.append("\n");
		card.append("|  .  |");
		card.append("\n");
		card.append("|___%s|");
		card.append("\n");
		return card.toString();
	}

}
