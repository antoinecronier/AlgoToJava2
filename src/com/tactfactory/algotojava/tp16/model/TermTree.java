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

	public TermTree(){
		termes = new ArrayList<TermTree>();
	}
	
	public TermTree(String terme){
		this();
		this.terme = terme;
	}

	public void add(TermTree termTree){
		this.termes.add(termTree);
	}
	
	public void remove(TermTree termTree){
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

	public List<String> getWords() {
		List<String> words = new ArrayList<String>();
		
		StringBuilder builder = new StringBuilder();
		
		int step = 0;
		for (TermTree termTree : termes) {
			builder.append(terme);
			builder.append(termTree.toString());
			builder.append(termTree.getWord(step));
			words.add(builder.toString());
			step++;
			builder = new StringBuilder();
		}
		
		return words;
	}
	
	public String getWord(int step){
		StringBuilder builder = new StringBuilder();
		
		builder.append(terme);
		
		for (TermTree termTree : termes) {
			for (String subtermTree : termTree.getWords()) {
				builder.append(subtermTree);
			}
		}
		
		return builder.toString();
	}
}
