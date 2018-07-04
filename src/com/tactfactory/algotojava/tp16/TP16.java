package com.tactfactory.algotojava.tp16;

import com.tactfactory.algotojava.tp16.manager.PasswordDiscoverer;
import com.tactfactory.algotojava.tp16.manager.TreeManager;
import com.tactfactory.algotojava.tp16.model.Tree;

/**
 * 
 * @author tactfactory
 *
 * 	- Ecrire une fonction qui prend un mot de passe en paramètre, un fichier et un entier
 * 	- La fonction accède au fichier afin d’utiliser les mots qu’il contient pour essayer de trouver le
 *		mot de passe
 * 	- L’entier passé en paramètre indique le nombre de combinaison de concaténation à réaliser
 *		avec les mots du fichier
 * 	-Lors d’une concaténation on testera les différentes disposition possible des mots du fichier
 * 	-La fonction renverra un tableau indiquant la position des mots utilisés pour trouver la solution
 *		de façon ordonnée
 * 	-Si aucun résultat n’est trouvé la fonction renverra un tableau d’une case avec la valeur -1
 *
 */
public class TP16 {

	public static void main(String[] args){
//		TreeManager manager = new TreeManager("keyWords");
//		manager.compileTree(7);
//		System.out.println(manager.printTree());
//		
//		String password = "1111111";
//		System.out.println(manager.contains(password));
//		
//		int[] passwordPositions = manager.containsPosition(password);
//		for (int i = 0; i < passwordPositions.length; i++) {
//			System.out.print(passwordPositions[i] + " ");
//		}
		PasswordDiscoverer disco = new PasswordDiscoverer(1, 20);
		disco.foundPassword("Fc23C6cZ");
	}
}
