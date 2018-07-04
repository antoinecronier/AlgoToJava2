package com.tactfactory.algotojava.tp16.model;

import java.util.ArrayList;
import java.util.List;

public class TermTree {

	private String terme;
	private List<TermTree> termes;

	public String getTerme() {
		return terme;
	}

	public void setTerme(String terme) {
		this.terme = terme;
	}

	public List<TermTree> getTermes() {
		return termes;
	}

	public TermTree() {
		termes = new ArrayList<TermTree>();
	}

	public TermTree(String terme) {
		this();
		this.terme = terme;
	}

	public void add(TermTree termTree) {
		this.termes.add(termTree);
	}

	public void remove(TermTree termTree) {
		this.termes.remove(termTree);
	}

	public String toString(int i) {
		StringBuilder builder = new StringBuilder();
		for (int j = 0; j < i; j++) {
			builder.append(" |");
		}
		builder.append(terme);
		builder.append("\n");

		i++;

		for (TermTree termTree : termes) {
			builder.append(termTree.toString(i));
		}

		return builder.toString();
	}

	@Override
	public String toString() {
		return terme;
	}

	public Boolean contains(String word) {
		Boolean result = false;

		System.out.println("test " + word + " with : " + terme);
		if (word.startsWith(terme)) {
			String newWord = word.substring(terme.length(), word.length());
			if (newWord.length() > 0) {
				for (TermTree termTree : termes) {
					if (termTree.contains(newWord)) {
						result = true;
						break;
					}
				}
			}else{
				result = true;
			}
		}
		
		return result;
	}
	
	public Boolean contains(String word, int[] order, int step) {
		Boolean result = false;

		System.out.println("test " + word + " with : " + terme);
		if (word.startsWith(terme)) {
			String newWord = word.substring(terme.length(), word.length());
			if (newWord.length() > 0 && step < order.length) {
				for (TermTree termTree : termes) {
					if (termTree.contains(newWord, order, step+1)) {
						result = true;
						order[step] = termes.indexOf(termTree) + 1;
						break;
					}
				}
			}else{
				result = true;
			}
		}
		
		return result;
	}
}
