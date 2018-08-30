package com.tactfactory.algotojava.tp18bis.model;

public class Carreau implements Family {
	
	public final static String[][] POKER_DECK = new String[][] { { "A ", "_A", "14" }, { "R ", "_R", "13" },
		{ "D ", "_D", "12" }, { "V ", "_V", "11" }, { "10", "10", "10" }, { "9 ", "_9", "9" }, { "8 ", "_8", "8" },
		{ "7 ", "_7", "7" }, };

	@Override
	public String getRepresentation() {
		StringBuilder card = new StringBuilder();
		card.append(" _____ ");
		card.append("\n");
		card.append("|%s^  |");
		card.append("\n");
		card.append("| / \\ |");
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
