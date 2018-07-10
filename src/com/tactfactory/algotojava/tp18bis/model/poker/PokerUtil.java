package com.tactfactory.algotojava.tp18bis.model.poker;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp18bis.model.Card;
import com.tactfactory.algotojava.tp18bis.model.Player;

public class PokerUtil {

	public static boolean win(Player winner, Player cardsHoldem) {
		boolean result = true;

		if (testQuinteFlush(new ArrayList<Card>(winner.getCards()))) {

			if (testQuinteFlush(new ArrayList<Card>(new ArrayList<Card>(cardsHoldem.getCards())))) {
				result = testUpperCard(winner, cardsHoldem);
			}
		} else if (testQuinteFlush(new ArrayList<Card>(cardsHoldem.getCards()))) {
			result = false;
		}

		else if (testSquare(new ArrayList<Card>(winner.getCards()))) {
			if (testSquare(new ArrayList<Card>(cardsHoldem.getCards()))) {
				result = testUpperCard(winner, cardsHoldem);
			}
		} else if (testSquare(new ArrayList<Card>(cardsHoldem.getCards()))) {
			result = false;
		}

		else if (testFull(new ArrayList<Card>(winner.getCards()))) {
			if (testFull(new ArrayList<Card>(cardsHoldem.getCards()))) {
				result = testUpperCard(winner, cardsHoldem);
			}
		} else if (testFull(new ArrayList<Card>(cardsHoldem.getCards()))) {
			result = false;
		}

		else if (testColor(new ArrayList<Card>(winner.getCards()))) {
			if (testColor(new ArrayList<Card>(cardsHoldem.getCards()))) {
				result = testUpperCard(winner, cardsHoldem);
			}
		} else if (testColor(new ArrayList<Card>(cardsHoldem.getCards()))) {
			result = false;
		}

		else if (testQuintes(new ArrayList<Card>(winner.getCards()))) {
			if (testQuintes(new ArrayList<Card>(cardsHoldem.getCards()))) {
				result = testUpperCard(winner, cardsHoldem);
			}
		} else if (testQuintes(new ArrayList<Card>(cardsHoldem.getCards()))) {
			result = false;
		}

		else if (testBrelan(new ArrayList<Card>(winner.getCards()))) {
			if (testBrelan(new ArrayList<Card>(cardsHoldem.getCards()))) {
				result = testUpperCard(winner, cardsHoldem);
			}
		} else if (testBrelan(new ArrayList<Card>(cardsHoldem.getCards()))) {
			result = false;
		}

		else if (testDoublePair(new ArrayList<Card>(winner.getCards()))) {
			if (testDoublePair(new ArrayList<Card>(cardsHoldem.getCards()))) {
				result = testUpperCard(winner, cardsHoldem);
			}
		} else if (testDoublePair(new ArrayList<Card>(cardsHoldem.getCards()))) {
			result = false;
		}

		else if (testPair(new ArrayList<Card>(winner.getCards()))) {
			if (testPair(new ArrayList<Card>(cardsHoldem.getCards()))) {
				result = testUpperCard(winner, cardsHoldem);
			}
		} else if (testPair(new ArrayList<Card>(cardsHoldem.getCards()))) {
			result = false;
		}

		else {
			result = testUpperCard(winner, cardsHoldem);
		}

		return result;
	}

	public static boolean testQuinteFlush(List<Card> cards) {
		boolean result = false;

		if (testColor(cards) && testQuintes(cards)) {
			result = true;
		}

		return result;
	}

	public static boolean testSquare(List<Card> cards) {
		boolean result = true;
		
		if (testSameValue(cards, 4).size() == 4) {
			result = true;
		}
		
		return result;
	}

	public static boolean testFull(List<Card> cards) {
		boolean result = true;
		
		List<Card> tempCards = testSameValue(cards, 2);
		
		if (tempCards.size() == 2) {
			cards.removeAll(tempCards);
			
			if (testSameValue(cards, 3).size() == 3) {
				result = true;
			}
		}
		
		return result;
	}

	public static boolean testColor(List<Card> cards) {
		boolean result = true;

		if (testColorValue(cards).size() == 5) {
			result = true;
		}

		return result;
	}

	public static boolean testQuintes(List<Card> cards) {
		boolean result = true;

		if (testQuinteValue(cards).size() == 5) {
			result = true;
		}

		return result;
	}

	public static boolean testBrelan(List<Card> cards) {
		boolean result = false;

		if (testSameValue(cards, 3).size() == 3) {
			result = true;
		}

		return result;
	}

	public static boolean testDoublePair(List<Card> cards) {
		boolean result = false;
		List<Card> tempCards = testSameValue(cards, 2);
		
		if (tempCards.size() == 2) {
			cards.removeAll(tempCards);
			
			if (testSameValue(cards, 2).size() == 2) {
				result = true;
			}
		}
		
		return result;
	}

	public static boolean testPair(List<Card> cards) {
		boolean result = false;

		if (testSameValue(cards, 2).size() == 2) {
			result = true;
		}

		return result;
	}
	
	public static List<Card> testColorValue(List<Card> cards) {
		List<Card> result = new ArrayList<Card>();
		
		cards.sort((o1, o2) -> o2.getValue().getValue().compareTo(o1.getValue().getValue()));

		while (cards.size() > 0 && result.size() < 5) {
			Card tempCard = cards.get(0);
			cards.remove(tempCard);
			for (Card card : cards) {
				if (tempCard.getFamily().equals(card.getFamily())) {
					if (!result.contains(tempCard)) {
						result.add(tempCard);
					}
					if (!result.contains(card)) {
						result.add(card);
					}
					if (result.size()==5) {
						break;
					}
					
					tempCard = card;
				}else {
					if (result.contains(tempCard) && result.size()!=5) {
						result.remove(tempCard);
					}
					if (result.contains(card)) {
						result.remove(tempCard);
					}
					break;
				}
			}
		}

		return result;
	}

	public static List<Card> testQuinteValue(List<Card> cards) {
		List<Card> result = new ArrayList<Card>();
		
		cards.sort((o1, o2) -> o2.getValue().getValue().compareTo(o1.getValue().getValue()));

		while (cards.size() > 0 && result.size() < 5) {
			Card tempCard = cards.get(0);
			cards.remove(tempCard);
			for (Card card : cards) {
				if (tempCard.getValue().getValue()-1 == card.getValue().getValue()) {
					if (!result.contains(tempCard)) {
						result.add(tempCard);
					}
					if (!result.contains(card)) {
						result.add(card);
					}
					
					tempCard = card;
				}else {
					if (result.contains(tempCard) && result.size()!=5) {
						result.remove(tempCard);
					}
					if (result.contains(card)) {
						result.remove(tempCard);
					}
					break;
				}
			}
		}

		return result;
	}

	public static List<Card> testSameValue(List<Card> cards, int nb) {
		List<Card> result = new ArrayList<Card>();

		while (cards.size() > 0 && result.size() < nb) {
			Card tempCard = cards.get(0);
			cards.remove(tempCard);
			for (Card card : cards) {
				if (tempCard.getValue().getValue() == card.getValue().getValue()) {
					if (!result.contains(tempCard)) {
						result.add(tempCard);
					}
					result.add(card);
					break;
				}
			}
		}

		return result;
	}

	private static boolean testUpperCard(Player list, Player list2) {
		boolean result = true;
		return true;
	}
}
