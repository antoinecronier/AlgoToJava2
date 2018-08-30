package com.tactfactory.algotojava.tp16.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp16.model.TermTree;
import com.tactfactory.algotojava.tp16.model.Tree;

public class TreeFileUtil {

	public static Tree GenerateTreeFromFile(String wordFile) throws IOException {
		Tree tree = new Tree();
		List<String> terms = new ArrayList<String>();
		FileReader in = null;
		BufferedReader br = null;
		try {
			in = new FileReader(wordFile);
			br = new BufferedReader(in);
			String line;
			while ((line = br.readLine()) != null) {
				terms.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (br != null) {
				br.close();
			}
		}
		
		tree.setTreeName(wordFile);
		
		for (String string : terms) {
			tree.getTermTree().add(new TermTree(string));
		}

		return tree;
	}
}
