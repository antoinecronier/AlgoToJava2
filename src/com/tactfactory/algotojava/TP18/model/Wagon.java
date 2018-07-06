package com.tactfactory.algotojava.TP18.model;

import java.util.ArrayList;
import java.util.List;

public class Wagon extends PartieDeTrain {

	List<Contenu> contenus;

	public List<Contenu> getContenus() {
		return contenus;
	}

	public Wagon(int poids) {
		super(poids);
		this.contenus = new ArrayList<Contenu>();
	}

	public boolean addContenu(Contenu contenu) {
		boolean result = false;

		if (this.contenus.isEmpty()) {
			this.contenus.add(contenu);
			result = true;
		} else if ((this.contenus.get(0) instanceof MarchandiseAnimal && contenu instanceof MarchandiseAnimal)
				|| (!(this.contenus.get(0) instanceof MarchandiseAnimal) && !(contenu instanceof MarchandiseAnimal))) {
			this.contenus.add(contenu);
			result = true;
		}

		return result;
	}
}
