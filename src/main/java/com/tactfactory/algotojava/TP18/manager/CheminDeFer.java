package com.tactfactory.algotojava.TP18.manager;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.TP18.model.Train;
import com.tactfactory.algotojava.TP18.model.Trajet;

public class CheminDeFer {

	private List<Trajet> trajets;
	private List<Train> trains;

	public CheminDeFer(List<Trajet> trajets, List<Train> trains) {
		super();
		this.trajets = trajets;
		this.trains = trains;
	}

	public void tour() {
		trains.sort((o1, o2) -> o2.getVitesseReel().compareTo(o1.getVitesseReel()));
		List<Train> trainRoule = new ArrayList<Train>();
		List<Train> trainBloque = new ArrayList<Train>();
		for (Train train : trains) {
			if (train.getVitesseReel() > 0 
					&& !train.getTrajet().getRail().isReparation()
					&& train.getTypeRail().equals(train.getTrajet().getRail().getTypeDeRail())) {
				trainRoule.add(train);
			}else{
				trainBloque.add(train);
			}
		}
		
		System.out.println("Les trains bloqués sont :");
		for (Train train : trainBloque) {
			System.out.println("\t"+train.getName() + " au départ de "+train.getTrajet().getGareDepart().getName() + " à "+train.getTrajet().getDepart() + " ne peut pas effectuer son voyage");
		}
		
		System.out.println("Les trains déplacé sont :");
		for (Train train : trainRoule) {
			System.out.println("\t"+train.getName() + " au départ de "+train.getTrajet().getGareDepart().getName() + " à "+train.getTrajet().getDepart() + " en direction de " + train.getTrajet().getGareArrive().getName() + " pour une arrivé à " + train.getTrajet().getGareArrive().getName() + " à bien circulé à une vitesse de " + train.getVitesseReel());
		}
		
		System.out.println("Information des gares :");
		for (Trajet trajet : trajets) {
			for (Train train : trainRoule) {
				if (trajet.equals(train.getTrajet())) {
					System.out.println("La gare " + trajet.getGareArrive().getName()+" acceuil le train " + train.getName() + " ayant roulé à " + train.getVitesseReel());
				}
			}
		}
	}
}
