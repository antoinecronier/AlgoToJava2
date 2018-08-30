package com.tactfactory.algotojava.tp17.model;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp17.model.rpg.Classe;

public abstract class Personnage {
	private final static String EQUIPWEAPON = "%s s'equipe d'une arme %s avec %s";
	private final static String EQUIPARMOR = "%s s'equipe d'une armure %s avec %s";

	private String name;
	Characteristic characteristic;
	private Arme arme;
	private Armure armure;
	private Classe classe;
	private List<Butin> butins;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Characteristic getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
	}

	public Arme getArme() {
		return arme;
	}
	
	public void setArme(Arme arme) {
		if (this.getClasse().isEquipable(arme)) {
			this.arme = arme;
			System.out.println(String.format(EQUIPWEAPON,this.getName(), arme.getClass().getSimpleName(),arme.getStats()));
		}else{
			System.out.println(this.getClasse().getWeaponRestriction());
		}
	}
	
	public Armure getArmure() {
		return armure;
	}
	
	public void setArmure(Armure armure) {
		if (this.getClasse().isEquipable(armure)) {
			this.armure = armure;
			System.out.println(String.format(EQUIPARMOR,this.getName(), armure.getClass().getSimpleName(),armure.getStats()));
		}else{
			System.out.println(this.getClasse().getArmorRestriction());
		}
	}
	
	public Classe getClasse() {
		return classe;
	}
	
	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public List<Butin> getButins() {
		return butins;
	}

	public void setButins(List<Butin> butins) {
		this.butins = butins;
	}
	
	public Personnage(){
		this.butins = new ArrayList<Butin>();
	}

	public Personnage(Classe classe) {
		this();
		this.classe = classe;
	}
}
