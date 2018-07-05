package com.tactfactory.algotojava.tp18bis.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Card> cards;
	private double money;
	private String name;
	
	public List<Card> getCards() {
		return cards;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Player(double money, String name) {
		super();
		this.cards = new ArrayList<Card>();
		this.money = money;
		this.name = name;
	}
}
