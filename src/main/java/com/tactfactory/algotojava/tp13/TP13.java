package com.tactfactory.algotojava.tp13;

import com.tactfactory.algotojava.tp13.utils.StringUtil;

/**
 * 
 * @author tactfactory
 *
 * 	- Ecrire une fonction de recherche qui remplace les caractères « et » dans une chaine et
 * 		retourne la chaine modifié
 * 	- Ecrire un algorithme qui utilise cette fonction et qui affiche la chaine avant et après
 * 		modification
 *
 */
public class TP13 {

	public static void main(String[] args){
		String chaine = "ma chaine et mon chaine Et la chaine ET cette chaine et ma derniere chaine";
		String remplacement = "couscous";
		System.out.println(StringUtil.remplaceEt1(chaine,remplacement));
		System.out.println(StringUtil.remplaceEt2(chaine,remplacement));
	}
}
