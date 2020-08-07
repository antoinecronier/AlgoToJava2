package com.tactfactory.algotojava.tp11procedural;

import java.util.Random;

/**
 * Créer une bataille navale où les bateaux sont générer aléatoirement sur une
 * carte pour chacun des joueurs et ou le programme jouera tout seul le jeux.
 *
 * @author tactfactory
 *
 */
public class TP11 {

  /**
   * Gestion des couleurs
   */
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  /**
   * Représente les informations des bateaux. identifiant | taille | nombre
   * par joueur.
   */
  private final static int[][] NAVIRES = new int[][] {
    { 1, 1, 1 },
    { 2, 3, 2 },
    { 3, 4, 2 },
    { 4, 6, 1 }
    };

  private final static int IDENTIFIANT = 0;
  private final static int TAILLE = 1;
  private final static int NOMBRE = 2;
  private final static int MAP_X = 18;
  private final static int MAP_Y = 24;

  private final static int JOUEURS = 2;

  /**
   * Cartes utilisé par l'ensemble des joueurs.
   */
  private static int[][][] maps;

  /**
   * Création d'un objet pour faire de l'aléatoire.
   */
  private static Random rand = new Random();

  /**
   * Contient le nom du joueur gagnant.
   */
  private static String gagnant;

  public static void main(String[] args) {
    // Initialisation du tableau des joueurs/
    if (args.length == 0) {
      // Mode 2 joueur.
      maps = new int[JOUEURS][MAP_X][MAP_Y];
    } else {
      // Mode multi joueur.
      maps = new int[Integer.parseInt(args[0])][MAP_X][MAP_Y];
    }

    // Création des variable utilisé dans la fonction.
    boolean fini = false;
    int cible = 0;

    placeToutBateau();

    // Boucle tant que le jeu n'est pas fini.
    while (!fini) {
      // Pour chaque joueur.
      for (int i = 0; !fini && i < maps.length; i++) {
        cible = trouveCible(i);

        // Si une cible est trouvé.
        if (cible != -1) {
          tire(cible);

          afficheCartePlacement(i);
          System.out.println();
        } else {
          // Le jeu est fini.
          fini = true;
        }
      }
    }

    // Je cherche le seul joueur encore en vie.
    for (int i = 0; i < maps.length; i++) {
      if (estVivant(i)) {
        gagnant = "joueur " + (i + 1);
      }
      afficheCartePlacement(i);
      System.out.println();
    }

    System.out.println("Le gagant est : " + gagnant);
  }

  /**
   * Indique si le joueur à l'indice joueur est encore considéré comme vivant.
   * @param joueur indice du joueur dans le tableau de jeu.
   * @return
   */
  public static boolean estVivant(int joueur) {
    boolean result = false;

    for (int i = 0; i < maps[joueur].length; i++) {
      for (int j = 0; j < maps[joueur][i].length; j++) {
        if (maps[joueur][i][j] != 0 && maps[joueur][i][j] != 8 && maps[joueur][i][j] != 9) {
          result = true;
        }
      }
    }

    return result;
  }

  /**
   * Place tous les bateaux pour tous les joueurs.
   */
  public static void placeToutBateau() {
    // Pour chaque joueur.
    for (int i = 0; i < maps.length; i++) {
      // Pour chaque navire.
      for (int[] navire : NAVIRES) {
        for (int j = 0; j < navire[NOMBRE]; j++) {
          placeBateau(i, navire);
        }
      }

      // Affiche la carte avec les bateaux placé pour le joueur courant.
      afficheCartePlacement(i);
      System.out.println();
    }

    System.out.println("Début du combat");
  }

  /**
   * Place un bateau pour un joueur.
   * @param joueur l'indice du joueur dans le tableau.
   * @param navire le tableau représentant le type de bateau à placer.
   */
  public static void placeBateau(int joueur, int[] navire) {
    // Création d'un objet pour faire de l'aléatoire.
    Random rand = new Random();

    // Tirage aléatoire de x et y;
    int x = rand.nextInt(MAP_X) % MAP_X;
    int y = rand.nextInt(MAP_Y) % MAP_Y;
    int direction = rand.nextInt(2) % 2;

    // Bateau placable aux coordonnées.
    if (estPlacable(joueur, navire, x, y, direction)) {
      placeBateauDansCarte(joueur, navire, x, y, direction);
    } else {
      placeBateau(joueur, navire);
    }
  }

  /**
   * Indique si un bateau peut être placé aux coordonnées x, y dans une direction donnée, pour un joueur donné
   * @param joueur l'indice du joueur dans le tableau
   * @param navire le tableau représentant le type de navire
   * @param x coordonnée X
   * @param y coordonnée Y
   * @param direction verticale ou horizontale
   * @return
   */
  public static boolean estPlacable(int joueur, int[] navire, int x, int y, int direction) {
    boolean result = true;

    switch (direction) {
    case 0:
      // Verticale.
      for (int i = 0; i < navire[TAILLE]; i++) {
        // Si hors de la carte.
        if (x + i >= MAP_X) {
          result = false;
        } else
        // Si la case contient déjà un bateau.
        if (maps[joueur][x + i][y] != 0) {
          result = false;
        }
      }
      break;

    case 1:
      // Horizontale.
      for (int i = 0; i < navire[TAILLE]; i++) {
        // Si hors de la carte.
        if (y + i >= MAP_Y) {
          result = false;
        } else
        // Si la case contient déjà un bateau.
        if (maps[joueur][x][y + i] != 0) {
          result = false;
        }
      }
      break;
    }

    return result;
  }

  /**
   * Place réellement le bateau sur la carte du joueur.
   * @param joueur l'indice du joueur dans le tableau
   * @param navire le tableau représentant le type de navire
   * @param x coordonnée X
   * @param y coordonnée Y
   * @param direction verticale ou horizontale
   */
  public static void placeBateauDansCarte(int joueur, int[] navire, int x, int y, int direction) {
    switch (direction) {
    case 0:
      // Verticale.
      for (int i = 0; i < navire[TAILLE]; i++) {
        maps[joueur][x + i][y] = navire[IDENTIFIANT];
      }
      break;

    case 1:
      // Horizontale.
      for (int i = 0; i < navire[TAILLE]; i++) {
        maps[joueur][x][y + i] = navire[IDENTIFIANT];
      }
      break;
    }
  }

  /**
   * Affiche la carte d'un joueur.
   * @param joueur l'indice du joueur dans le tableau.
   */
  public static void afficheCartePlacement(int joueur) {
    for (int i = 0; i < maps[joueur].length; i++) {
      for (int j = 0; j < maps[joueur][i].length; j++) {
        StringBuilder result = new StringBuilder();
        switch (maps[joueur][i][j]) {
        case 8:
          result.append(ANSI_YELLOW);
          break;
        case 9:
          result.append(ANSI_RED);
          break;
        case 1:
        case 2:
        case 3:
        case 4:
          result.append(ANSI_PURPLE);
          break;
        default:
          result.append(ANSI_BLUE);
          break;
        }
        result.append(maps[joueur][i][j]);
        result.append(" ");
        result.append(ANSI_RESET);
        System.out.print(result.toString());
      }
      System.out.println();
    }
  }

  public static void afficheCarteJeu(int joueur) {

  }

  /**
   * Trouve la prochaine cible en vie.
   * @param attaquant l'indice de l'attaquant.
   * @return l'adversaire suivant.
   */
  public static int trouveCible(int attaquant) {
    int adversaire = -1;
    boolean flag = true;
    int i = attaquant;

    do {
      // Vérification de l'indice pour ne pas sortir du tableau
      if (i + 1 == maps.length) {
        i = 0;
      } else {
        i++;
      }

      if (estVivant(i)) {
        adversaire = i;
        flag = false;
      }
    } while (flag && i != attaquant);

    if (i == attaquant) {
      adversaire = -1;
    }

    return adversaire;
  }

  /**
   * Tire sur le joueur ciblé
   * @param joueurCible indice du joueur ciblé
   */
  public static void tire(int joueurCible) {
    // Tirage aléatoire de x et y;
    int x = -1;
    int y = -1;

    do {
      x = rand.nextInt(MAP_X) % MAP_X;
      y = rand.nextInt(MAP_Y) % MAP_Y;

      if (maps[joueurCible][x][y] == 0) {
        maps[joueurCible][x][y] = 8;
      } else if (maps[joueurCible][x][y] == 1 || maps[joueurCible][x][y] == 2 || maps[joueurCible][x][y] == 3
          || maps[joueurCible][x][y] == 4) {
        maps[joueurCible][x][y] = 9;
      }
    } while (maps[joueurCible][x][y] != 8 && maps[joueurCible][x][y] != 9);
  }
}
