package com.tactfactory.algotojava.tp11bis;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp11bis.model.Client;
import com.tactfactory.algotojava.tp11bis.model.Echoppe;
import com.tactfactory.algotojava.tp11bis.model.Produit;
import com.tactfactory.algotojava.tp11bis.model.produits.Fruit;
import com.tactfactory.algotojava.tp11bis.model.produits.Jouet;
import com.tactfactory.algotojava.tp11bis.model.produits.Legume;
import com.tactfactory.algotojava.tp11bis.model.produits.Soda;
import com.tactfactory.algotojava.tp11bis.model.produits.Viande;

/**
 * 
 * TP11Bis
 * 
 * En java créer une échoppe qui vendra tout type de produit :
 * 	- Fruit / Légume
 * 	- Viande
 * 	- Jouet
 * 	- Tabac
 * 	- ...
 * 
 * Chaque produit sera achetable, ce qui veut dire que l'on pourra directement l'acheter et aussi l'embaler
 * 
 * Dans votre réalisation vous devez définir au moins 3 façons différente d'emballer un type spécifique de produit.
 * 
 * Afin de pouvoir acheter des produits un utilisateur possédera un panier, dans lequel il pourra stocker les différent produit souhaiter et pourra acheter l'ensemble de ces produits
 * 
 * 
 * @author tactfactory
 *
 */
public class TP11 {

	public static void main(String[] args){
		Echoppe echoppe = new Echoppe();
		Echoppe echoppe1 = new Echoppe();
		
		Legume conconbre = new Legume(3, "conconbre");
		
		echoppe1.getProduits().clear();
		echoppe.getProduits().clear();
		
		echoppe1.getProduits().add(conconbre);
		echoppe.getProduits().add(conconbre);
		
		
		Client client = new Client();
		client.setMoney(100.00);
		for (int i = 0; i < echoppe.getProduits().size(); i+=7) {
			echoppe.getProduits().get(i).acheter(client);
			echoppe.getProduits().remove(echoppe.getProduits().get(i));
		}
		
		System.out.println("Il reste " + client.getMoney() + " au client.");
	}
}
