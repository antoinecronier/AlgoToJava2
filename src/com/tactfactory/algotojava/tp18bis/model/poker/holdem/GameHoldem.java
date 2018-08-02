package com.tactfactory.algotojava.tp18bis.model.poker.holdem;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp18bis.model.Card;
import com.tactfactory.algotojava.tp18bis.model.Family;
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
	Player lastRaiser;
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
			this.currentPlayers = new ArrayList<PlayerHoldem>(players);
			this.dealer = dealer;
			this.currentDealer = players.get(0);
			this.smallBlind = (PlayerHoldem)getNext(this.currentDealer);
			this.bigBlind = (PlayerHoldem)getNext(this.smallBlind);
			this.nextCaller = (PlayerHoldem)getNext(this.bigBlind);
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
		List<Player> players = new ArrayList<Player>(this.currentPlayers);
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
		lastRaiser = bigBlind;
		boolean firstHavePlayed = false;
		while (!firstHavePlayed || !allPlayersHavePlayed()) {
			firstHavePlayed = true;
			
			if (firstHavePlayed) {
				
			}
			
			double checkPrice = ((PlayerHoldem) getPrevious(nextCaller)).getCurrentBet();
			
			if (nextCaller instanceof Human) {
				((Human)nextCaller).printDisplay();
			}
			
			if (nextCaller.getMoney() <= 0) {
				this.players.remove(nextCaller);
			}
			
			if (this.currentPlayers.size() > 1) {
				PokerActions choice;
				switch (choice = nextCaller.call()) {
				case CHECK:
					
					if (nextCaller.canCheck(checkPrice)) {
						nextCaller.setMoney(nextCaller.getMoney() - checkPrice);
						this.pot -= nextCaller.getCurrentBet();
						nextCaller.setCurrentBet(checkPrice);
						this.pot += nextCaller.getCurrentBet();
					}
					break;
				case RAISE:
					lastRaiser = nextCaller;
					double raise;
					if ((raise = nextCaller.canRaise(checkPrice,this.pot)) > -1) {
						nextCaller.setMoney(nextCaller.getMoney() - raise);
						this.pot -= nextCaller.getCurrentBet();
						nextCaller.setCurrentBet(raise + nextCaller.getCurrentBet());
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

				//print player action
				System.out.println("Le joueur " + nextCaller.getName() + " choisi de " + choice);
				System.out.println("Le joueur à engagé " + nextCaller.getCurrentBet() + " sur la table, il lui reste " + nextCaller.getMoney());
				
			}else{
				break;
			}
			this.nextCaller = (PlayerHoldem) getNext(this.nextCaller);
		}
		endBet();
	}

	private void endBet() {
		this.allHavePlayed = false;
		this.lastRaiser = this.currentDealer;
		this.nextCaller = (PlayerHoldem) getPrevious(this.nextCaller);
	}

	private boolean allPlayersHavePlayed() {
		if (lastRaiser.equals(nextCaller)) {
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
		
		this.smallBlind.setMoney(this.smallBlind.getMoney() - (startingBet/2));
		this.smallBlind.setCurrentBet(startingBet/2);
		this.pot += startingBet/2;
		
		this.bigBlind.setMoney(this.bigBlind.getMoney() - startingBet);
		this.bigBlind.setCurrentBet(startingBet);
		this.pot += startingBet;
		
		this.nextCaller = (PlayerHoldem) getNext(bigBlind);
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
		checkWinner();
		this.currentPlayers = new ArrayList<PlayerHoldem>(this.players);
		for (PlayerHoldem playerHoldem : this.players) {
			playerHoldem.getTable().clear();
			playerHoldem.getHand().clear();
		}
		this.table.clear();
		this.pot = 0;
		this.dealer = new DealerHoldem();
	}

	private void checkWinner() {
		PlayerHoldem winner = currentPlayers.get(0);
		winner.getTable().addAll(getTable());
		List<PlayerHoldem> winners = new ArrayList<PlayerHoldem>();
		currentPlayers.remove(winner);
		for (PlayerHoldem playerHoldem : currentPlayers) {
			playerHoldem.getTable().addAll(getTable());
			if (PokerUtil.win(winner,playerHoldem)) {
				winner = playerHoldem;
				winners.add(playerHoldem);
			}
		}
		
		if (winners.size() == 0) {
			winners.add(winner);
		}
		
		System.out.println("Le pot était de " + pot);
		for (PlayerHoldem playerHoldem : winners) {
			this.print();
			playerHoldem.print();
			playerHoldem.setMoney(playerHoldem.getMoney() + (pot/winners.size()));
		}
		
		for (PlayerHoldem playerHoldem : players) {
			System.out.println("Le joueur " + playerHoldem.getName() + " possède maintenant " + playerHoldem.getMoney() + " argent");
		}
	}

	@Override
	public void print() {
		System.out.println("Cards on table");

		StringBuilder builder = new StringBuilder();
		List<String> strings = new ArrayList<String>();

		for (int i = 0; i < Family.SIZE_REPRESENTATION; i++) {
			for (int j = 0; j < this.getTable().size(); j++) {
				builder.append(this.getTable().get(j).printExpression().get(i) + "  ");
			}
			
			strings.add(builder.toString());
			builder = new StringBuilder();
		}
		
		for (String string : strings) {
			builder.append(string+"\n");
		}

		System.out.println(builder.toString());
	}
}
