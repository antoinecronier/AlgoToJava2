package com.tactfactory.algotojava.tp16.model;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private List<TermTree> termTrees;
	private String treeName;
	
	public List<TermTree> getTermTree() {
		return termTrees;
	}
	
	public String getTreeName() {
		return treeName;
	}
	
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	
	public Tree(){
		this.termTrees = new ArrayList<TermTree>();
	}
	
	public boolean contains(String word){
		boolean result = false;
		
		for (TermTree termTree : termTrees) {
			System.out.println("test " + word + " with : " + termTree.getTerme());
			if (termTree.contains(word)) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	public int[] containsPosition(String word,int inheritance){
		int[] result = new int[inheritance];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}
		
		for (TermTree termTree : termTrees) {
			System.out.println("test " + word + " with : " + termTree.getTerme());
			if (word.startsWith(termTree.getTerme())) {
				result[0] = termTrees.indexOf(termTree)+1;
			}
			
			if (termTree.contains(word,result,1)) {
				break;
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			if (result[i] == -1) {
				result = new int[]{-1};
				break;
			}
		}
		
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getTreeName());
		builder.append("\n");
		for (TermTree termTree : termTrees) {
			builder.append(termTree.toString(1));
		}
		return builder.toString();
	}
}
