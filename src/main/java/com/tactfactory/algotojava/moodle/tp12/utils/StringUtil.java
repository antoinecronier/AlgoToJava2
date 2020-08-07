package com.tactfactory.algotojava.moodle.tp12.utils;

public class StringUtil {

  private static final String REMPLACER = "\\set\\s|\\seT\\s|\\sEt\\s|\\sET\\s";

  public static String remplaceEt1(String chaine,String remplaceFor){
    StringBuilder builder = new StringBuilder();

    String[] splited = chaine.split(REMPLACER);
    for (int i = 0; i < splited.length; i++) {
      builder.append(splited[i]);
      builder.append(" " +remplaceFor+ " ");
      builder.append("\n");
    }
    return builder.toString();
  }

  public static String remplaceEt2(String chaine,String remplaceFor){
    return chaine.replaceAll(REMPLACER, " "+remplaceFor+" " + "\n");
  }
}
