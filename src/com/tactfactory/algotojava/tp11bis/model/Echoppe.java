package com.tactfactory.algotojava.tp11bis.model;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp11bis.model.produits.Fruit;
import com.tactfactory.algotojava.tp11bis.model.produits.Jouet;
import com.tactfactory.algotojava.tp11bis.model.produits.Legume;
import com.tactfactory.algotojava.tp11bis.model.produits.Soda;
import com.tactfactory.algotojava.tp11bis.model.produits.Viande;

public class Echoppe {

	List<Produit> produits = new ArrayList<Produit>();
	
	
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> echoppe) {
		this.produits = echoppe;
	}

	public Echoppe(){
		
		for (int i = 0; i < 10; i++) {
			produits.add(new Fruit(2,"pomme"));
			produits.add(new Legume(3,"salade"));
			produits.add(new Jouet(10,"lego"));
			produits.add(new Soda(2,"coca cola"));
			produits.add(new Viande(10, "steack"));
		}
	}
}
