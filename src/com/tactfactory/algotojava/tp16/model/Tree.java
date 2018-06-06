package com.tactfactory.algotojava.tp16.model;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private List<TermTree> termTree;
	private String treeName;
	
	public List<TermTree> getTermTree() {
		return termTree;
	}
	
	public String getTreeName() {
		return treeName;
	}
	
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	
	public Tree(){
		this.termTree = new ArrayList<TermTree>();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getTreeName());
		builder.append("\n");
		for (TermTree termTree : termTree) {
			builder.append(termTree.toString(1));
		}
		return builder.toString();
	}
}
