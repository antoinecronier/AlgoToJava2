package com.tactfactory.algotojava.tp17.manager;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp17.model.Arme;
import com.tactfactory.algotojava.tp17.model.ArmeMagique;
import com.tactfactory.algotojava.tp17.model.ArmeMixte;
import com.tactfactory.algotojava.tp17.model.ArmePhysique;
import com.tactfactory.algotojava.tp17.model.Armure;
import com.tactfactory.algotojava.tp17.model.ArmureMagique;
import com.tactfactory.algotojava.tp17.model.ArmureMixte;
import com.tactfactory.algotojava.tp17.model.ArmurePhysique;
import com.tactfactory.algotojava.tp17.model.Butin;
import com.tactfactory.algotojava.tp17.model.Characteristic;
import com.tactfactory.algotojava.tp17.model.Hero;
import com.tactfactory.algotojava.tp17.model.Mob;
import com.tactfactory.algotojava.tp17.model.Personnage;
import com.tactfactory.algotojava.tp17.model.rpg.Barbare;
import com.tactfactory.algotojava.tp17.model.rpg.Classe;
import com.tactfactory.algotojava.tp17.model.rpg.Mage;
import com.tactfactory.algotojava.tp17.model.rpg.Paladin;
import com.tactfactory.algotojava.tp17.model.rpg.defaultclasse.DefaultFighter;

public class PersonnageBuilder {

	private Personnage personnage;
	private Classe classe;
	private Arme arme;
	private Armure armure;
	private String name;
	private Characteristic characteristic;
	private List<Butin> butins;

	public PersonnageBuilder() {
		this.butins = new ArrayList<Butin>();
	}

	public PersonnageBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public PersonnageBuilder setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
		return this;
	}

	public PersonnageBuilder setButins(List<Butin> butins) {
		this.butins = butins;
		return this;
	}

	public PersonnageBuilder setPersonnageType(Personnage personnage) {
		this.personnage = personnage;
		return this;
	}

	public PersonnageBuilder setClasse(Classe classe) {
		this.classe = classe;
		return this;
	}

	/////////////////////// Defaults ////////////////////////////
	
	public PersonnageBuilder setDefaultCharacteristic(){
		this.characteristic = new Characteristic(23, 8);
		return this;
	}
	
	public PersonnageBuilder setDefaultEquipment(){
		if (this.personnage.getClasse() instanceof Barbare) {
			this.arme = new ArmePhysique(3, 2);
			this.armure = new ArmurePhysique(2);
		}else if (this.personnage.getClasse() instanceof Mage) {
			this.arme = new ArmeMagique(3, 2);
			this.armure = new ArmureMagique(2);
		}else if (this.personnage.getClasse() instanceof Paladin) {
			this.arme = new ArmeMixte(new ArmePhysique(2, 1),new ArmeMagique(2, 2));
			this.armure = new ArmureMixte(new ArmureMagique(2),new ArmurePhysique(2));
		}else{
			this.arme = new ArmePhysique(3, 2);
			this.armure = new ArmurePhysique(2);
		}
		return this;
	}
	
	public PersonnageBuilder setDefaultHero(Classe classe){
		this.personnage = new Hero();
		this.classe = classe;
		this.personnage.setClasse(classe);
		setDefaultCharacteristic();
		setDefaultEquipment();
		return this;
	}
	
	/////////////////// mob generation /////////////////
	public PersonnageBuilder setDefaultMob(int difficulty){
		this.personnage = new Mob();
		this.classe = new DefaultFighter();
		this.personnage.setClasse(classe);
		setDefaultCharacteristic(difficulty);
		setDefaultEquipment(difficulty);
		return this;
	}

	private PersonnageBuilder setDefaultEquipment(int difficulty) {
		if (this.personnage.getClasse() instanceof Barbare) {
			this.arme = new ArmePhysique(3, 2);
			this.armure = new ArmurePhysique(2);
		}else if (this.personnage.getClasse() instanceof Mage) {
			this.arme = new ArmeMagique(3, 2);
			this.armure = new ArmureMagique(2);
		}else if (this.personnage.getClasse() instanceof Paladin) {
			this.arme = new ArmeMixte(new ArmePhysique(2, 1),new ArmeMagique(2, 2));
			this.armure = new ArmureMixte(new ArmureMagique(2),new ArmurePhysique(2));
		}else{
			this.arme = new ArmePhysique(3, 2);
			this.armure = new ArmurePhysique(2);
		}
		return this;
	}

	private PersonnageBuilder setDefaultCharacteristic(int difficulty) {
		this.characteristic = new Characteristic(23, 8);
		return this;
	}

	public Personnage build() {
		if (personnage == null) {
			personnage = new Mob();
		}
		
		if (classe == null) {
			classe = new DefaultFighter();
		}
		
		if (arme == null) {
			arme = new ArmePhysique(1,2);
		}
		
		if (armure == null) {
			armure = new ArmurePhysique(0);
		}
		
		if (characteristic == null) {
			characteristic = new Characteristic(5,2);
		}
		
		if (name == null || name.equals("")) {
			name = "unamed";
		}
		
		if (butins.isEmpty() && personnage != null && personnage instanceof Mob) {
			butins = LootGenerator.generateLoots();
		}

		this.personnage.setName(name);
		this.personnage.setClasse(classe);
		this.personnage.getClasse().setPersonnage(personnage);
		this.personnage.setArme(arme);
		this.personnage.setArmure(armure);
		this.personnage.setCharacteristic(characteristic);
		this.personnage.setButins(butins);
		
		return personnage;
	}
}
