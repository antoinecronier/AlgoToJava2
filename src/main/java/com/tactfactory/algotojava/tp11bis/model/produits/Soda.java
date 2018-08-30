package com.tactfactory.algotojava.tp11bis.model.produits;

import com.tactfactory.algotojava.tp11bis.model.Emballage;
import com.tactfactory.algotojava.tp11bis.model.Produit;

public class Soda extends Produit {

	public Soda(double price, String name) {
		super(price, name);
	}

	@Override
	public void embaler() {
		this.setEmballage(new Emballage("bouteille"));
		System.out.println(String.format(EMBALLE, this.getName(),String.format(EMBALLE_WITH, "une " + this.getEmballage().getName())));
	}
}
