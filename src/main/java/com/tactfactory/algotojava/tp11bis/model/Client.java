package com.tactfactory.algotojava.tp11bis.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private String name;
	private Double money;
	private List<Produit> produits = new ArrayList<Produit>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getMoney() {
		return money;
	}
	
	public void setMoney(Double money) {
		this.money = money;
	}
	
	public List<Produit> getProduits() {
		return produits;
	}
	
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}
