package com.tactfactory.algotojava.tp17.model;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp17.model.rpg.Classe;
import com.tactfactory.algotojava.tp17.model.rpg.Paladin;

public abstract class Personnage {
	private final static String EQUIPWEAPON = "%s s'equipe d'une arme %s avec %s";
	private final static String EQUIPARMOR = "%s s'equipe d'une armure %s avec %s";

	private String name;
	private int life;
	private int actionPoint;
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
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public int getActionPoint() {
		return actionPoint;
	}
	
	public void setActionPoint(int actionPoint) {
		this.actionPoint = actionPoint;
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
