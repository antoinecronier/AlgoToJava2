package com.tactfactory.algotojava.tp6;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author tactfactory
 *
 * 	- Un étudiant veut faire cuire des côtes d’agneaux
 *	- En fonction de la cuisson bleu indice 1, saignant indice 2, cuit indice 3,
 *		à point indice 4 et brûlé indice 5 l’étudiant effectuera différentes
 *		actions
 *	-Si le repas n’est pas à point il laissera le repas cuire
 *	-Si le repas est brûlé alors il sera déçu
 *	-Si le repas est à point alors il sera content
 *	L’étudiant lancera l’algo à chaque fois qui voudra connaitre l’état de son
 *		repas
 *
 */
public class TP6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int selection;
		Cuisson cuisson = null;
		
		Random rand = new Random();
		selection = rand.nextInt(5) + 1;
		
		switch (selection) {
		case 1:
			cuisson = Cuisson.Bleu;
			break;
		case 2:
			cuisson = Cuisson.Saignant;
			break;
		case 3:
			cuisson = Cuisson.Cuit;
			break;
		case 4:
			cuisson = Cuisson.APoint;
			break;
		case 5:
			cuisson = Cuisson.Brule;
			break;
		}
		
		switch (cuisson) {
		case Bleu:
		case Saignant:
		case Cuit:
			System.out.println(Statisfaction.Cuire);
			break;
		case APoint:
			System.out.println(Statisfaction.Content);
			break;
		case Brule:
			System.out.println(Statisfaction.Decu);
			break;
		}
		
		sc.close();
	}
	
	public enum Cuisson{
		Bleu,
		Saignant,
		Cuit,
		APoint,
		Brule
	}
	
	public enum Statisfaction{
		Cuire,
		Decu,
		Content
	}
}
