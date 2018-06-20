package com.tactfactory.algotojava.tp16.manager;

import java.io.IOException;
import java.util.List;

import com.tactfactory.algotojava.tp16.model.TermTree;
import com.tactfactory.algotojava.tp16.model.Tree;
import com.tactfactory.algotojava.tp16.utils.TreeFileUtil;

public class TreeManager {
	private int baseInheritance;
	private Tree tree;

	public Tree getTree() {
		return tree;
	}

	public TreeManager() {
		tree = new Tree();
	}

	public TreeManager(String wordFile) {
		this();
		try {
			tree = TreeFileUtil.GenerateTreeFromFile(wordFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void compileTree(int inheritance) {
		baseInheritance = inheritance;
		if (inheritance > 1) {
			for (TermTree termTree : tree.getTermTree()) {
				compileSubTermTree(termTree, inheritance, tree.getTermTree());
			}
		}
	}
	
	public void compileSubTermTree(TermTree termTree, int inheritance, List<TermTree> baseUsedTerms){

		for (TermTree subTermTree : baseUsedTerms) {
				TermTree tempTermTree = new TermTree(subTermTree.getTerme());
				termTree.add(tempTermTree);
		}
		inheritance--;
		if (inheritance > 1) {
			for (TermTree subTermTree : termTree.getTermes()) {
				compileSubTermTree(subTermTree,inheritance,baseUsedTerms);
			}
		}
	}
	
	public String contains(String password){
		String result = null;
		for (TermTree termTree : tree.getTermTree()) {
			for (String word : termTree.getWords()) {
				
				System.out.println(word);
				if (password.equals(word)) {
					result = word;
				}
			}
		}
		
		return result;
	}

	public String printTree() {
		StringBuilder builder = new StringBuilder();

		builder.append(tree.toString());

		return builder.toString();
	}
}
