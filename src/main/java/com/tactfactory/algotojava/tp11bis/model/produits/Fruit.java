package com.tactfactory.algotojava.tp11bis.model.produits;

import com.tactfactory.algotojava.tp11bis.model.Emballage;
import com.tactfactory.algotojava.tp11bis.model.Produit;

public class Fruit extends Produit {

	public Fruit(double price, String name) {
		super(price, name);
	}

	@Override
	public void embaler() {
		this.setEmballage(new Emballage("cagette"));
		System.out.println(String.format(EMBALLE, this.getName(),String.format(EMBALLE_WITH, "une " + this.getEmballage().getName())));
	}
}
