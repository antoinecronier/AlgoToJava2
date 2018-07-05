package com.tactfactory.algotojava.tp18bis.model.poker.holdem;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp18bis.model.Card;
import com.tactfactory.algotojava.tp18bis.model.Human;
import com.tactfactory.algotojava.tp18bis.model.Player;
import com.tactfactory.algotojava.tp18bis.model.Printable;
import com.tactfactory.algotojava.tp18bis.model.poker.PokerActions;
import com.tactfactory.algotojava.tp18bis.model.poker.PokerUtil;
import com.tactfactory.algotojava.tp18bis.utils.ListUtil;

public class GameHoldem implements HoldemGame, Printable {

	List<PlayerHoldem> players;
	List<PlayerHoldem> currentPlayers;
	List<Card> table;
	DealerHoldem dealer;
	PlayerHoldem bigBlind;
	PlayerHoldem smallBlind;
	Player currentDealer;
	PlayerHoldem nextCaller;
	double pot;
	double startingBet;
	private boolean allHavePlayed;

	public List<PlayerHoldem> getPlayers() {
		return players;
	}

	public List<PlayerHoldem> getCurrentPlayers() {
		return currentPlayers;
	}

	public List<Card> getTable() {
		return table;
	}

	public DealerHoldem getDealer() {
		return dealer;
	}

	@Override
	public Player getBigBlind() {
		return this.bigBlind;
	}

	@Override
	public Player getSmallBlind() {
		return this.smallBlind;
	}

	@Override
	public double getPot() {
		return this.pot;
	}

	public double getStartingBet() {
		return startingBet;
	}

	public GameHoldem(List<PlayerHoldem> players, DealerHoldem dealer, double startingBet) throws Exception {
		super();
		if (players.size() <= 4 && players.size() >= 2) {
			this.players = players;
			this.currentPlayers = players;
			this.dealer = dealer;
			this.currentDealer = players.get(0);
			this.smallBlind = (PlayerHoldem)getNext(this.currentDealer);
			this.bigBlind = (PlayerHoldem)getNext(this.smallBlind);
			this.startingBet = startingBet;
		} else {
			throw new Exception("Cannot get more than 4 players or less than 2 players");
		}
		this.table = new ArrayList<Card>();
		allHavePlayed = false;
	}

	public GameHoldem() {
		players = new ArrayList<PlayerHoldem>();
		currentPlayers = new ArrayList<PlayerHoldem>();
		dealer = new DealerHoldem();
		allHavePlayed = false;
	}

	@Override
	public void dealFirstTurnCards() {
		List<Player> players = new ArrayList<>(this.players);
		this.currentPlayers = this.players;
		dealer.dealInitialCards(players);
	}

	@Override
	public void addPlayer(Player player) throws Exception {
		if (players.size() < 4) {
			players.add((PlayerHoldem) player);
		} else {
			throw new Exception("Players cannot be more than 4");
		}
	}

	@Override
	public Player getNext(Player player) {
		List<Object> items = new ArrayList<Object>(currentPlayers);
		return (Player) ListUtil.next(items, player);
	}

	@Override
	public Player getPrevious(Player player) {
		List<Object> items = new ArrayList<Object>(currentPlayers);
		return (Player) ListUtil.previous(items, player);
	}

	@Override
	public void bet() {
		while (!allPlayersHavePlayed() || !playersBetAreEquals()) {
			double checkPrice = ((PlayerHoldem) getPrevious(nextCaller)).getCurrentBet();
			
			if (nextCaller instanceof Human) {
				((Human)nextCaller).printDisplay();
			}
			
			if (this.currentPlayers.size() > 1) {
				PokerActions choice;
				switch (choice = nextCaller.call()) {
				case CHECK:
					
					if (nextCaller.canCheck(checkPrice)) {
						nextCaller.setMoney(nextCaller.getMoney() - checkPrice);
						this.pot -= nextCaller.getCurrentBet();
						nextCaller.setCurrentBet(nextCaller.getCurrentBet() + checkPrice);
						this.pot += nextCaller.getCurrentBet();
					}
					break;
				case RAISE:
					double raise;
					if ((raise = nextCaller.canRaise(checkPrice,this.pot)) > -1) {
						nextCaller.setMoney(nextCaller.getMoney() - raise);
						this.pot -= nextCaller.getCurrentBet();
						nextCaller.setCurrentBet(raise);
						this.pot += nextCaller.getCurrentBet();
					}
					break;
				case PASS:
					this.currentPlayers.remove(nextCaller);
					break;
				case LEAVE:
					this.currentPlayers.remove(nextCaller);
					this.players.remove(nextCaller);
					break;
				}
				
				System.out.println("Le joueur " + nextCaller.getName() + " choisi de " + choice);
				
			}else{
				break;
			}
			

			this.nextCaller = (PlayerHoldem) getNext(this.nextCaller);
		}
		allHavePlayed = false;
	}

	private boolean allPlayersHavePlayed() {
		if (getPrevious(bigBlind).equals(nextCaller)) {
			allHavePlayed = true;
		}
		
		return allHavePlayed;
	}

	private boolean playersBetAreEquals() {
		boolean result = true;

		PlayerHoldem tempPlayer = currentPlayers.get(0);
		for (PlayerHoldem playerHoldem : currentPlayers) {
			if (tempPlayer.getCurrentBet() != playerHoldem.getCurrentBet()) {
				result = false;
				break;
			} else {
				tempPlayer = playerHoldem;
			}
		}

		return result;
	}

	@Override
	public void initialBet() {
		for (PlayerHoldem playerHoldem : currentPlayers) {
			playerHoldem.setCurrentBet(0);
		}
		
		this.bigBlind.setMoney(this.bigBlind.getMoney() - startingBet);
		this.bigBlind.setCurrentBet(startingBet);
		this.smallBlind.setMoney(this.smallBlind.getMoney() - (startingBet/2));
		this.smallBlind.setCurrentBet(startingBet/2);
		this.nextCaller = (PlayerHoldem) getNext(smallBlind);
	}

	public void dealFlopCards() {
		dealer.burnCard();
		this.table.add(dealer.giveCard());
		this.table.add(dealer.giveCard());
		this.table.add(dealer.giveCard());
	}

	public void dealTurnCards() {
		dealer.burnCard();
		this.table.add(dealer.giveCard());
	}

	public void dealRiverCards() {
		dealer.burnCard();
		this.table.add(dealer.giveCard());
	}
	
	public void endTurn() {
		this.table.clear();
		this.pot = 0;
		this.dealer = new DealerHoldem();
		checkWinner();
	}

	private void checkWinner() {
		PlayerHoldem winner = currentPlayers.get(0);
		List<PlayerHoldem> winners = new ArrayList<PlayerHoldem>();
		for (PlayerHoldem playerHoldem : currentPlayers) {
			if (PokerUtil.win(winner,playerHoldem)) {
				winner = playerHoldem;
				winners.add(playerHoldem);
			}
			
		}
		
		for (PlayerHoldem playerHoldem : winners) {
			playerHoldem.setMoney(playerHoldem.getMoney() + (pot/winners.size()));
		}
		
		for (PlayerHoldem playerHoldem : players) {
			System.out.println("Le joueur " + playerHoldem.getName() + " possède maintenant " + playerHoldem.getMoney() + " argent");
		}
	}

	@Override
	public void print() {
		for (Card card : this.table) {
			card.print();
		}
	}
}
