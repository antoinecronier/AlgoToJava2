package com.tactfactory.algotojava.moodle.tp11.utils;

import java.util.Scanner;

public class Conjugateur {
  private static final String[] PRONOM = {"je","tu","il","nous","vous","ils"};
  private static final String[] TERMINAISON = {"e","es","e","ons","ez","ent"};
  private static final String[] VOYELLE = {"a","e","i","o","u"};
  private static final String[] VARIATION_NOUS = {"g"};

  private static final Scanner sc = new Scanner(System.in);

  public static String conjugue(String verbe){
    StringBuilder builder = new StringBuilder();
    String radical = verbe.substring(0,verbe.length()-2);

    for (int i = 0; i < 6; i++) {
      boolean variante = false;
      switch (i) {
      case 0:
        for (int j = 0; j < VOYELLE.length; j++) {
          if (radical.startsWith(VOYELLE[j])) {
            variante = true;
          }
        }
        if (variante) {
          builder.append(PRONOM[i].substring(0, 1) + "'" + " " + radical + TERMINAISON[i] + "\n");
        }else{
          builder.append(PRONOM[i] + " " + radical + TERMINAISON[i] + "\n");
        }
        break;

      case 3:
        for (int j = 0; j < VARIATION_NOUS.length; j++) {
          if (radical.endsWith(VARIATION_NOUS[j])) {
            variante = true;
          }
        }
        if (variante) {
          builder.append(PRONOM[i] + " " + radical + "e" + TERMINAISON[i] + "\n");
        }else{
          builder.append(PRONOM[i] + " " + radical + TERMINAISON[i] + "\n");
        }
        break;
      default:
        builder.append(PRONOM[i] + " " + radical + TERMINAISON[i] + "\n");
        break;
      }
    }

    return builder.toString();
  }

  public static void autoConjugue(String[] elements){
    for (int i = 0; i < elements.length; i++) {
      System.out.println(conjugue(elements[i]));
    }
  }

  public static void conjugueAvecSaisi(){
    String saisi = "";

    do {
      System.out.println("Saisir un verbe du 1er groupe");
      saisi = sc.nextLine();
    } while (!saisi.endsWith("er") && !saisi.equals("aller"));

    System.out.println(conjugue(saisi));
  }
}
