package com.tactfactory.algotojava.tp11.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tactfactory.algotojava.tp11.model.Case;
import com.tactfactory.algotojava.tp11.model.Joueur;
import com.tactfactory.algotojava.tp11.model.Navire;

public class Jeu {
	
	private static final int TAILLE_X = 24;
	private static final int TAILLE_Y = 18;

	Random rand = new Random();
	
	private List<Joueur> joueurs;
	
	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public Jeu(){
		this.joueurs = new ArrayList<Joueur>();
	}
	
	public Jeu(int nbJoueur){
		this();
		for (int i = 0; i < nbJoueur; i++) {
			this.joueurs.add(new Joueur(1,"joueur " + (i + 1)));
		}
	}
	
	public void play(){
		for (Joueur joueur : joueurs) {
			placementBateaux(joueur);
		}
		
		boolean continuer = true;
		while (continuer) {
			for (Joueur joueur : joueurs) {
				if (joueur.getVivant()) {
					Joueur adversaire = trouveAdversaire(joueur);
					if (adversaire != null) {
						attaquer(joueur,adversaire);
					}else{
						continuer = false;
					}
				}
			}
			afficherTour();
		}
		
		System.out.println("Fin de partie");
	}

	private void afficherTour() {
		for (Joueur joueur : joueurs) {
			afficheMapTire(joueur);
		}
	}

	private void attaquer(Joueur joueur, Joueur adversaire) {
		int x = rand.nextInt(TAILLE_X);
		int y = rand.nextInt(TAILLE_Y);
		while (!simpleFireTry(joueur, adversaire, x, y)) {
			x = rand.nextInt(TAILLE_X);
			y = rand.nextInt(TAILLE_Y);
		}
	}

	private boolean simpleFireTry(Joueur joueur, Joueur adversaire, int x, int y) {
		boolean result = false;
		Case testCase = new Case(x, y);
		boolean dejaTire = false;
		for (Case caseE : joueur.getTires()) {
			if (caseE.getX() == x && caseE.getY() == y) {
				dejaTire = true;
			}
		}
		if (!dejaTire) {
			for (Navire navire : adversaire.getMap()) {
				for (Case caseE : navire.getCases()) {
					if (caseE.getX() == x && caseE.getY() == y) {
						caseE.setTouche(true);
						testCase.setTouche(true);
					}
				}
			}
			joueur.getTires().add(testCase);
			result= true;
		}
		return result;
	}
	
	private Joueur trouveAdversaire(Joueur joueur) {
		Joueur adversaire = null;
		boolean flag = true;
		int i = 0;
		do {
			// Vérification de l'indice pour ne pas sortir du tableau
			if (i + 1 == joueurs.size()) {
				i = 0;
			} else {
				i++;
			}

			if (joueurs.get(i).getVivant()) {
				adversaire = joueurs.get(i);
				flag = false;
			}
		} while (flag && adversaire != null && !adversaire.equals(joueur));
		return adversaire;
	}

	private void placementBateaux(Joueur joueur) {
		for (Navire navire : joueur.getMap()) {
			placementBateau(joueur, navire);
		}
	}

	private void placementBateau(Joueur joueur, Navire navire) {
		Random rand = new Random();
		int x = rand.nextInt(TAILLE_X);
		int y = rand.nextInt(TAILLE_Y);
		int direction = rand.nextInt(2);
		if (bateauPlacable(navire,x,y,direction, joueur)) {
			placeBateau(navire,x,y,direction);
		}else{
			placementBateau(joueur, navire);
		}
	}

	private void placeBateau(Navire navire, int x, int y, int direction) {
		switch (direction) {
		// Droite
		case 0:
			for (int i = 0; i < navire.getTaille(); i++) {
				new Case(x + i, y).setNavire(navire);
			}
			break;
		// Bas
		case 1:
			for (int i = 0; i < navire.getTaille(); i++) {
				new Case(x, y + i).setNavire(navire);
			}
			break;
		}
	}

	private boolean bateauPlacable(Navire navire, int x, int y, int direction, Joueur joueur) {
		boolean result = true;
		switch (direction) {
		// Droite
		case 0:
			for (int i = 0; i < navire.getTaille(); i++) {
				if (x + i >= TAILLE_X || caseExiste(x + i, y, joueur)) {
					result = false;
				}
			}
			break;
		// Bas
		case 1:
			for (int i = 0; i < navire.getTaille(); i++) {
				if (y + i >= TAILLE_Y || caseExiste(x, y + i, joueur)) {
					result = false;
				}
			}
			break;
		}
		return result;
	}

	private boolean caseExiste(int x, int y, Joueur joueur) {
		boolean result = false;
		for (Navire navire : joueur.getMap()) {
			for (Case caseItem : navire.getCases()) {
				if (caseItem.getX() == x && caseItem.getY() == y) {
					result = true;
				}
			}
		}

		return result;
	}
	
	public void afficheMap(Joueur joueur){
		boolean dontFindCase = true;
		StringBuilder column = new StringBuilder();
		for (int i = 0; i < TAILLE_X; i++) {
			StringBuilder line = new StringBuilder();
			for (int j = 0; j < TAILLE_Y; j++) {
				for (Navire navire : joueur.getMap()) {
					for (Case caseE : navire.getCases()) {
						if (caseE.getX() == i && caseE.getY() == j) {
							if (!caseE.isTouche()) {
								line.append(" " + navire.getIdentifiant());
							}else{
								line.append(" X");
							}
							dontFindCase = false;
						}
					}
				}
				if (dontFindCase) {
					line.append(" 0");
				}else{
					dontFindCase = true;
				}
			}
			column.append(line.toString()+"\n");
		}
		System.out.println("Carte du joueur " + joueur.getNom());
		System.out.println(column);
	}
	


	private void afficheMapTire(Joueur joueur) {
		boolean dontFindCase = true;
		StringBuilder column = new StringBuilder();
		for (int i = 0; i < TAILLE_X; i++) {
			StringBuilder line = new StringBuilder();
			for (int j = 0; j < TAILLE_Y; j++) {
					for (Case caseE : joueur.getTires()) {
						if (caseE.getX() == i && caseE.getY() == j) {
							if (!caseE.isTouche()) {
								line.append("()");
							}else{
								line.append(" X");
							}
							dontFindCase = false;
						}
				}
				if (dontFindCase) {
					line.append(" 0");
				}else{
					dontFindCase = true;
				}
			}
			column.append(line.toString()+"\n");
		}
		System.out.println("Carte du joueur " + joueur.getNom());
		System.out.println(column);
	}
}
