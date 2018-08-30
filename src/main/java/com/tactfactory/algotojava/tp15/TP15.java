package com.tactfactory.algotojava.tp15;

import java.io.IOException;

import com.tactfactory.algotojava.tp13.utils.StringUtil;
import com.tactfactory.algotojava.tp15.utils.FileUtil;

public class TP15 {

	public static void main(String[] args) {
		try {
			System.out.println(
					StringUtil
						.remplaceEt2(
								FileUtil.getFromFileMemory("texte.txt"), 
								"couscous"));
			
			System.out.println();
			
			System.out.println(
					StringUtil
						.remplaceEt2(
								FileUtil.getFromFilePlainText("texte.txt"), 
								"couscous"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
