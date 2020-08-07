package com.tactfactory.algotojava.moodle.tp15.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tactfactory.algotojava.moodle.tp15.model.Butin;
import com.tactfactory.algotojava.moodle.tp15.model.Personnage;

public class Combat {

  private static final String ROUND_NB = "Tour %d :";
  private static final String FIGHT_START = "Debut du combat entre %s et %s";
  private static final String CHARACTER_ALIVE = "le personnage %s est encore vivant avec %d points de vie ";
  private static final String CHARACTER_DIED = "le personnage %s est mort ";
  private final static String FIGHT_ENDED = "Le combat est fini : \n\tequipe1 : %s\n\tequipe2 : %s";

  private List<Personnage> attackers;
  private List<Personnage> defenders;

  public Combat(List<Personnage> attackers, List<Personnage> defenders) {
    super();
    this.attackers = attackers;
    this.defenders = defenders;
  }

  public List<Butin> fightNoBack(){
    List<Butin> butins = new ArrayList<>();

    while (teamAlive(attackers)&&teamAlive(defenders)) {
      fight();
    }

    for (Personnage attacker : attackers) {
      if (attacker.getCharacteristic().getLife() <= 0) {
        butins.addAll(attacker.getButins());
      }
    }
    for (Personnage defender : defenders) {
      if (defender.getCharacteristic().getLife() <= 0) {
        butins.addAll(defender.getButins());
      }
    }

    return butins;
  }

  public void fight() {
    setUp(attackers);
    setUp(defenders);

    int round = 1;
    System.out.println(String.format(FIGHT_START, showTeams(attackers), showTeams(defenders)));

    Personnage attacker = null;
    Personnage defender = null;
    while ((attacker = findNextAliveCharacter(attackers,attacker)) != null
        && (defender = findNextAliveCharacter(defenders,defender)) != null
        ) {
      System.out.println(String.format(ROUND_NB, round));
      round(attacker, defender);
      round(defender, attacker);
      round++;
    }

    System.out
        .println(String.format(FIGHT_ENDED, showCharactersResult(attackers), showCharactersResult(defenders)));
  }

  private boolean teamAlive(List<Personnage> personnages){
    boolean result = false;

    for (Personnage personnage : personnages) {
      if (personnage.getCharacteristic().getLife()>0) {
        result = true;
      }
    }

    return result;
  }

  private Personnage findNextAliveCharacter(List<Personnage> personnages, Personnage lastPersonnage) {
    Personnage result = null;

    for (Personnage personnage : personnages) {
      if (personnage.getCharacteristic().getLife() > 0 && personnage.getCharacteristic().getCurrentActionPoint() - personnage.getArme().getActionPoint() >= 0 && !personnage.equals(lastPersonnage)) {
        result = personnage;
        break;
      }
    }

    if (result == null && lastPersonnage.getCharacteristic().getLife() > 0 && lastPersonnage.getCharacteristic().getCurrentActionPoint() - lastPersonnage.getArme().getActionPoint() >= 0) {
      result = lastPersonnage;
    }

    return result;
  }

  private void setUp(List<Personnage> personnages) {
    for (Personnage personnage : personnages) {
      personnage.getCharacteristic().setCurrentActionPoint(personnage.getCharacteristic().getActionPoint());
    }
  }

  private String showTeams(List<Personnage> personnages) {
    StringBuilder result = new StringBuilder();

    for (Personnage personnage : personnages) {
      result.append(personnage.getName() + " ");
    }

    return result.toString();
  }

  private String showCharactersResult(List<Personnage> personnages) {
    StringBuilder result = new StringBuilder();

    for (Personnage personnage : personnages) {
      if (personnage.getCharacteristic().getLife() <= 0) {
        result.append(String.format(CHARACTER_DIED, personnage.getName()));
      } else {
        result.append(String.format(CHARACTER_ALIVE, personnage.getName(), personnage.getCharacteristic().getLife()));
      }
    }

    return result.toString();
  }

  private void round(Personnage attacker, Personnage defender) {
    if (attacker.getCharacteristic().getCurrentActionPoint() - attacker.getArme().getRealActionPoint() >= 0) {
      attacker.getCharacteristic().setCurrentActionPoint(attacker.getCharacteristic().getCurrentActionPoint() - attacker.getArme().getActionPoint());
      attacker.getClasse().fight(defender);
    }
  }
}
