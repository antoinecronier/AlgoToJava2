package com.tactfactory.algotojava.tp12.manager;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Conjugateur {
	private static final String[] pronom = {"je","tu","il","nous","vous","ils"};
	private static final String[] terminaison = {"e","es","e","ons","ez","ent"};
	private static final String[] voyelle = {"a","e","i","o","u"};
	private static final String[] variationNous = {"g"};
	
	private static final Scanner sc = new Scanner(System.in);
	
	public static String conjugue(String verbe){
		StringBuilder builder = new StringBuilder();
		String radical = verbe.substring(0,verbe.length()-2);

		for (int i = 0; i < 6; i++) {
			boolean variante = false;
			switch (i) {
			case 0:
				for (int j = 0; j < voyelle.length; j++) {
					if (radical.startsWith(voyelle[j])) {
						variante = true;
					}
				}
				if (variante) {
					builder.append(pronom[i].substring(0, 1) + "'" + " " + radical + terminaison[i] + "\n");
				}else{
					builder.append(pronom[i] + " " + radical + terminaison[i] + "\n");
				}
				break;
				
			case 3:
				for (int j = 0; j < variationNous.length; j++) {
					if (radical.endsWith(variationNous[j])) {
						variante = true;
					}
				}
				if (variante) {
					builder.append(pronom[i] + " " + radical + "e" + terminaison[i] + "\n");
				}else{
					builder.append(pronom[i] + " " + radical + terminaison[i] + "\n");
				}
				break;
			default:
				builder.append(pronom[i] + " " + radical + terminaison[i] + "\n");
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
