package com.tactfactory.algotojava.tp16.manager;

import com.tactfactory.algotojava.tp16.model.Tree;

public class PasswordDiscoverer {

	private int startRange;
	private int endRange;
	
	public PasswordDiscoverer(int startRange, int endRange){
		this.startRange = startRange;
		this.endRange = endRange;
	}
	
	public boolean foundPassword(String pwd){
		boolean result = false;
		TreeManager manager = new TreeManager("keyWords2");
		manager.quickCompileTree(endRange);
		
		for (int i = startRange; i <= endRange; i++) {
			int[] passwordPositions = manager.containsPosition(pwd,i);
			if (passwordPositions.length > 0) {
				for (int j = 0; j < passwordPositions.length; j++) {
					System.out.print(passwordPositions[j]+" ");
				}
				
				if (passwordPositions.length == pwd.length()) {
					result = true;
					break;
				}
			}
		}
		
		if (!result) {
			System.out.print("Not founded");
		}
		
		return result;
	}
}
