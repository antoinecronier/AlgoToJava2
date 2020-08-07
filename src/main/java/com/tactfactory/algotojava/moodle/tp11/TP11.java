package com.tactfactory.algotojava.moodle.tp11;

import com.tactfactory.algotojava.moodle.tp11.utils.Conjugateur;

/**
 *
 * @author tactfactory
 *
 * 	- Créer un programme qui conjugue au présent de l'indicatif des verbes régulier du premier groupe
 *	- Un tableau de string doit contenir les verbes à conjuguer et être passé en paramètre d'une fonction
 *	- Le programme doit afficher chaque verbe conjugué pour tout les pronoms
 *  - Permettre à l'utilisateur de saisir un verbe du premier groupe non irrégulier
 *  - Le programme doit afficher le verbe de l'utilisateur conjugué pour tout les pronoms
 *
 */
public class TP11 {

  public static void main(String[] args){
    Conjugateur.autoConjugue(new String[]{
        "accepter",
        "entrer",
        "préparer",
        "acheter",
        "envoyer",
        "présenter",
        "aider",
        "espérer",
        "prier",
        "aimer",
        "essayer",
        "prononcer",
        "manger"
        });
    Conjugateur.conjugueAvecSaisi();
  }
}
