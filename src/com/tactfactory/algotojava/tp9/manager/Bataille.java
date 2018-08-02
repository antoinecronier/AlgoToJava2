package com.tactfactory.algotojava.tp9.manager;

import java.util.Scanner;

import com.tactfactory.algotojava.tp9.model.Arme;
import com.tactfactory.algotojava.tp9.model.ArmeType;
import com.tactfactory.algotojava.tp9.model.Armure;
import com.tactfactory.algotojava.tp9.model.ArmureType;
import com.tactfactory.algotojava.tp9.model.Personnage;

public class Bataille {
	private static Scanner sc = new Scanner(System.in);
	private Personnage[] joueurs;

	private static final String GAGNE = "%s inflige %d dégats à %s, il reste %d vie à %s";
	private static final String INEFFICACE = "%s n'arrive pas a faire des dégats à %s";
	private static final String FINJEU = "Le joueur %s gagne le match";

	/**
	 * Fonction principale permettant de combatre
	 */
	public void combatre() {
		boolean notEnded = true;
		while (notEnded) {
			for (int i = 0; notEnded && i < joueurs.length; i++) {
				if (joueurs[i].getVie() > 0) {
					Personnage defenseur = trouveDefenseur(i);
					if (defenseur == null) {
						combatSuccessMessage(joueurs[i]);
						notEnded = false;
					} else {
						combat(joueurs[i], defenseur);
					}
				}
			}
		}
	}

	/**
	 * Affiche la fin de jeu avec le gagnant
	 * 
	 * @param personnage
	 *            (gagnant)
	 */
	private void combatSuccessMessage(Personnage personnage) {
		System.out.println(String.format(FINJEU, personnage.getNom()));
	}

	/**
	 * Permet de trouver le prochain defenseur.
	 * 
	 * @param attaquant
	 *            (entier représentant le joueur courrant)
	 * @return null si aucun defenseur trouvé ou le prochain defenseur
	 */
	private Personnage trouveDefenseur(int attaquant) {
		int i = attaquant;
		Personnage defenseur = null;

		// Boucle tant que l'on est pas revenu au départ
		boolean flag = true;
		do {
			// Vérification de l'indice pour ne pas sortir du tableau
			if (i + 1 == joueurs.length) {
				i = 0;
			} else {
				i++;
			}

			if (joueurs[i].getVie() > 0 && i != attaquant) {
				defenseur = joueurs[i];
				flag = false;
			}
			
			if (i == attaquant) {
				flag = false;
			}
		} while (flag);

		// Retourne le defenseur suivant ou null si la partie est fini
		return defenseur;
	}

	/**
	 * Combat entre 2 personnages
	 * 
	 * @param attaquant
	 * @param defenseur
	 */
	public void combat(Personnage attaquant, Personnage defenseur) {
		int pa = attaquant.getAction();
		// L'attaquant s'équipe de l'arme.
		pa--;
		while (pa - attaquant.getArme().getAction() >= 0) {
			pa -= attaquant.getArme().getAction();
			if (attaquant.getArme().getDega() - defenseur.getArmure().getArmure() > 0) {
				defenseur.setVie(
						defenseur.getVie() - (attaquant.getArme().getDega() - defenseur.getArmure().getArmure()));
				fightSuccessMessage(attaquant, defenseur);
				if (defenseur.getVie() <= 0) {
					return;
				}
			} else {
				fightLoseMessage(attaquant, defenseur);
			}
		}
	}

	/**
	 * Affichage si des points de vie sont enlevé
	 * 
	 * @param attaquant
	 * @param defenseur
	 */
	public void fightSuccessMessage(Personnage attaquant, Personnage defenseur) {
		System.out.println(String.format(GAGNE, attaquant.getNom(),
				attaquant.getArme().getDega() - defenseur.getArmure().getArmure(), defenseur.getNom(),
				defenseur.getVie(), defenseur.getNom()));
	}

	/**
	 * Affichage si aucun points de vie n'a été enlevé
	 * 
	 * @param attaquant
	 * @param defenseur
	 */
	public void fightLoseMessage(Personnage attaquant, Personnage defenseur) {
		System.out.println(String.format(INEFFICACE, attaquant.getNom(), defenseur.getNom()));
	}

	/**
	 * Constructeur permettant l'initialisation par l'utilisateur du jeu
	 */
	public Bataille() {
		super();
		
//		// Test avec données de l'énnoncé
//		this.joueurs = new Personnage[3];
//		this.joueurs[0] = new Personnage(9, 7, new Arme(ArmeType.Pelle), new Armure(ArmureType.GiletBleu), "perso1");
//		this.joueurs[1] = new Personnage(4, 12, new Arme(ArmeType.Blaster), new Armure(ArmureType.ArmureDeCuir),
//				"perso2");
//		this.joueurs[2] = new Personnage(15, 8, new Arme(ArmeType.Concasseur), new Armure(ArmureType.ArmureDePlaque),
//				"perso3");

		// Action utilisateur pour définir les personnages
		int joueurs = 0;
		do {
			System.out.println("Combien de joueurs?");
			joueurs = sc.nextInt();
		} while (joueurs < 2);
		this.joueurs = new Personnage[joueurs];

		
		for (int i = 0; i < this.joueurs.length; i++) {
			this.joueurs[i] = selectionPerso(i + 1);
		}
	}

	/**
	 * Configuration d'un personnage par l'utilisateur
	 * 
	 * @param numero
	 * @return
	 */
	private Personnage selectionPerso(int numero) {
		String nom = "";

		// Parce que l'on a utilisé nextInt(), le caratère de fin de chaine
		// n'avait pas été récupéré.
		// Afin de ne pas afficher les informations 2 fois on vide le contenu
		// restant du scanner avec nextLine();
		sc.nextLine();

		System.out.println(String.format("Nom personnage %d : ", numero));
		nom = sc.nextLine();

		int vie = selectInt(String.format("Vie personnage %d : ", numero),0);

		int action = selectInt(String.format("Action personnage %d : ", numero),0);
//		do {
//			System.out.println(String.format("Action personnage %d : ", numero));
//			action = sc.nextInt();
//		} while (action <= 0);
//
//		// Parce que l'on a utilisé nextInt(), le caratère de fin de chaine
//		// n'avait pas été récupéré.
//		// Afin de ne pas afficher les informations 2 fois on vide le contenu
//		// restant du scanner avec nextLine();
//		sc.nextLine();

		String armeSelection = "";

		do {
			System.out.println(String.format("Arme personnage %d dans la liste : ", numero));
			for (ArmeType s : ArmeType.values()) {
				System.out.println(String.format("%s ", s));
			}

			armeSelection = sc.nextLine();
		} while (checkEnumValue(armeSelection, ArmeType.values()));
		Arme arme = new Arme(ArmeType.valueOf(armeSelection));

		String armureSelection = "";

		do {
			System.out.println(String.format("Armure personnage %d : ", numero));
			for (ArmureType s : ArmureType.values()) {
				System.out.println(String.format("%s ", s));
			}

			armureSelection = sc.nextLine();
		} while (checkEnumValue(armureSelection, ArmureType.values()));
		Armure armure = new Armure(ArmureType.valueOf(armureSelection));

		return new Personnage(vie, action, arme, armure, nom);
	}

	private int selectInt(String print, int min) {
		int result = 0;
		do {
			System.out.println(print);
			try {
				result = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Saisir une valeur entière.");
				result = selectInt(print, min);
				break;
			}
		} while (result <= min);
		return result;
	}

	/**
	 * Permet la vérification d'une chaine avec les valeurs de l'énumration
	 * ArmeType
	 * 
	 * @param armeSelection
	 * @param values
	 * @return
	 */
	private boolean checkEnumValue(String armeSelection, ArmeType[] values) {
		boolean result = true;
		for (int i = 0; i < values.length; i++) {
			if (values[i].name().equals(armeSelection)) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * Permet la vérification d'une chaine avec les valeurs de l'énumration
	 * ArmureType
	 * 
	 * @param armureSelection
	 * @param values
	 * @return
	 */
	private boolean checkEnumValue(String armureSelection, ArmureType[] values) {
		boolean result = true;
		for (int i = 0; i < values.length; i++) {
			if (values[i].name().equals(armureSelection)) {
				result = false;
			}
		}
		return result;
	}
}
