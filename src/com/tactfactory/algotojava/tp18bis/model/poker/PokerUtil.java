package com.tactfactory.algotojava.tp18bis.model.poker;

import java.util.List;

import com.tactfactory.algotojava.tp18bis.model.Card;
import com.tactfactory.algotojava.tp18bis.model.Player;

public class PokerUtil {

	public static boolean win(Player winner, Player cardsHoldem) {
		boolean result = true;
		return result;
	}
	
	public static boolean testQuinteFlush(List<Card> cards){
		boolean result = false;
		
		if (testColor(cards) && testQuintes(cards)) {
			result = true;
		}
		
		return result;
	}
	
	public static boolean testSquare(List<Card> cards){
		boolean result = true;
		return result;
	}
	
	public static boolean testFull(List<Card> cards){
		boolean result = true;
		return result;
	}
	
	public static boolean testColor(List<Card> cards){
		boolean result = true;
		
		Card tempCard = cards.get(0);
		for (int i = 1; i < cards.size(); i++) {
			if (tempCard.getFamily().equals(cards.get(i))) {
				tempCard = cards.get(i);
			}else{
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	public static boolean testQuintes(List<Card> cards){
		boolean result = true;
		
		cards.sort((o1, o2) -> o1.getValue().getValue().compareTo(o2.getValue().getValue()));
		
		Card tempCard = cards.get(0);
		for (int i = 1; i < cards.size(); i++) {
			if (tempCard.getValue().getValue() == cards.get(i).getValue().getValue() - 1) {
				tempCard = cards.get(i);
			}else{
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	public static boolean testBrelan(List<Card> cards){
		boolean result = false;
		
		Card tempCard = cards.get(0);
		if (cards.size() != 3) {
			for (int i = 1; i < cards.size(); i++) {
				if (tempCard.getValue().getValue() == cards.get(i).getValue().getValue()) {
					result = true;
					break;
				}
			}
			
			if (!result) {
				cards.remove(tempCard);
				testBrelan(cards);
			}
		}
		
		return result;
	}
	
	public static boolean testDoublePair(List<Card> cards){
		boolean result = true;
		return result;
	}
	
	public static boolean testPair(List<Card> cards){
		boolean result = false;
	
		Card tempCard = cards.get(0);
		if (cards.size() != 2) {
			for (int i = 1; i < cards.size(); i++) {
				if (tempCard.getValue().getValue() == cards.get(i).getValue().getValue()) {
					result = true;
					break;
				}
			}
			
			if (!result) {
				cards.remove(tempCard);
				testPair(cards);
			}
		}
		
		return result;
	}
}
