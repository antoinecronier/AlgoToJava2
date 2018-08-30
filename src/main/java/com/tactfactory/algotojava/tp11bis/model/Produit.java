package com.tactfactory.algotojava.tp11bis.model;

public abstract class Produit implements Achetable {
	
	public static final String EMBALLE = "Le produit %s %s";
	public static final String EMBALLE_WITH = "a été emballé avec %s";

	private Emballage emballage;
	private double price;
	private String name;
	
	public Emballage getEmballage() {
		return emballage;
	}
	
	public void setEmballage(Emballage emballage) {
		this.emballage = emballage;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Produit(double price, String name) {
		this.price = price;
		this.name = name;
	}

	@Override
	public void acheter(Client client) {
		client.getProduits().add(this);
		client.setMoney(client.getMoney()-this.price);
		embaler();
	}

	@Override
	public void embaler() {
		this.setEmballage(new Emballage("sac plastique"));
		System.out.println(String.format(EMBALLE, this.name,String.format(EMBALLE_WITH, "un " + this.getEmballage().getName())));
	}
}
