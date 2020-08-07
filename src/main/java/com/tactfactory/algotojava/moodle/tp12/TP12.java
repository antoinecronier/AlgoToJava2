package com.tactfactory.algotojava.moodle.tp12;

import com.tactfactory.algotojava.moodle.tp12.utils.StringUtil;

/**
 *
 * @author tactfactory
 *
 * 	- Créer un programme qui cherche une occurrence d'une chaîne dans une chaîne et qui la remplace
 * 	- Créer une classe utilitaire contenant deux fonctions arrivant au même résultat
 *     - Une fonction utilisera la fonction "split" disponible sur les objets de type String
 *     - Une fonction utilisera la fonction "replaceAll" disponible sur les objets de type String
 *  - Votre programme dois rechercher toutes les variations suivante*
 *     - et
 *     - eT
 *     - Et
 *     - ET
 *  - Le terme de remplacement et la chaîne initiale est à votre convenance
 *
 */
public class TP12 {

  public static void main(String[] args){
    String chaine = "ma chaine et mon chaine Et la chaine ET cette chaine et ma derniere chaine";
    String remplacement = "couscous";
    System.out.println(StringUtil.remplaceEt1(chaine,remplacement));
    System.out.println(StringUtil.remplaceEt2(chaine,remplacement));
  }
}
