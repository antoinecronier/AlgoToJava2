package com.tactfactory.algotojava.TP18;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tactfactory.algotojava.TP18.manager.CheminDeFer;
import com.tactfactory.algotojava.TP18.model.*;

public class TP18 {

	public static void main(String[] args) {
		// Gares
		Gare gare1 = new Gare("Gare1");
		Gare gare2 = new Gare("Gare2");
		Gare gare3 = new Gare("Gare3");

		// TypeRail
		TypeRail typeRail1 = new TypeRail("Type A");
		TypeRail typeRail2 = new TypeRail("Type B");
		TypeRail typeRail3 = new TypeRail("Type C");

		// Rail
		Rail rail1 = new Rail(typeRail1,true);
		Rail rail2 = new Rail(typeRail1);
		Rail rail3 = new Rail(typeRail1);
		Rail rail4 = new Rail(typeRail2);
		Rail rail5 = new Rail(typeRail2);
		Rail rail6 = new Rail(typeRail3);
		Rail rail7 = new Rail(typeRail3);
		Rail rail8 = new Rail(typeRail3);
		Rail rail9 = new Rail(typeRail3);

		// Dates
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
		Date date1 = null;
		Date date2 = null;
		Date date3 = null;
		Date date4 = null;
		Date date5 = null;
		Date date6 = null;
		Date date7 = null;
		Date date8 = null;
		Date date9 = null;

		try {
			date1 = formatter.parse("01/29/02 12:24:59");
			date2 = formatter.parse("01/29/02 13:24:59");
			date3 = formatter.parse("01/29/02 14:02:30");
			date4 = formatter.parse("01/29/02 15:13:10");
			date5 = formatter.parse("01/29/02 16:24:00");
			date6 = formatter.parse("01/29/02 17:24:00");
			date7 = formatter.parse("01/29/02 18:24:00");
			date8 = formatter.parse("01/29/02 19:24:00");
			date9 = formatter.parse("01/29/02 20:24:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Trajets
		Trajet trajet1 = new Trajet(gare1, gare2, date1, date2, rail1);
		Trajet trajet2 = new Trajet(gare2, gare1, date1, date2, rail2);
		Trajet trajet3 = new Trajet(gare3, gare2, date1, date2, rail3);

		// Wagons
		Wagon wagon1 = new Wagon(1000);
		for (int i = 0; i < 10; i++) {
			wagon1.addContenu(new Passager("passager", ""+i, 80));
		}
		wagon1.addContenu(new Passager("jean", "pierre", 160));
		wagon1.addContenu(new Marchandise("cailloux",8000));
		wagon1.addContenu(new Passager("ivon", "jacque", 130));
		
		Wagon wagon2 = new Wagon(500);
		for (int i = 0; i < 10; i++) {
			wagon2.addContenu(new Marchandise("marchandise"+i,10*i));
		}
		
		Wagon wagon3 = new Wagon(400);
		for (int i = 0; i < 10; i++) {
			wagon3.addContenu(new Marchandise("marchandise"+i,10*i));
		}
		
		Wagon wagon4 = new Wagon(1200);
		for (int i = 0; i < 10; i++) {
			wagon4.addContenu(new Animal("animal"+i,10*i));
		}
		
		Wagon wagon5 = new Wagon(2222);
		for (int i = 0; i < 10; i++) {
			wagon5.addContenu(new Animal("animal"+i,10*i));
		}
		
		Wagon wagon6 = new Wagon(3066);
		for (int i = 0; i < 10; i++) {
			wagon6.addContenu(new Animal("animal"+i,10*i));
		}
		
		Wagon wagon7 = new Wagon(10000);
		for (int i = 0; i < 10; i++) {
			wagon7.addContenu(new Animal("animal"+i,10*i));
		}
		
		Wagon wagon8 = new Wagon(1900);
		for (int i = 0; i < 10; i++) {
			wagon8.addContenu(new Marchandise("marchandise"+i,10*i));
		}
		
		Wagon wagon9 = new Wagon(1000);

		List<Wagon> wagons1 = new ArrayList<Wagon>() {
			{
				add(wagon1);
				add(wagon2);
				add(wagon3);
				add(wagon4);
			}
		};

		List<Wagon> wagons2 = new ArrayList<Wagon>() {
			{
				add(wagon5);
				add(wagon6);
				add(wagon7);
			}
		};

		List<Wagon> wagons3 = new ArrayList<Wagon>() {
			{
				add(wagon8);
				add(wagon9);
			}
		};

		// Machine de tête
		MachineDeTete machineDeTete1 = new MachineDeTete(200, 6000, 1000);
		MachineDeTete machineDeTete2 = new MachineDeTete(150, 6000, 1000);
		MachineDeTete machineDeTete3 = new MachineDeTete(50, 2000, 200);

		// Trains
		Train train1 = new Train("train1",trajet1, wagons1, machineDeTete1, typeRail1);
		Train train2 = new Train("train2",trajet2, wagons2, machineDeTete2, typeRail1);
		Train train3 = new Train("train3",trajet3, wagons3, machineDeTete3, typeRail2);

		// CheminDeFer
		List<Trajet> trajets = new ArrayList<Trajet>() {
			{
				add(trajet1);
				add(trajet2);
				add(trajet3);
			}
		};

		List<Train> trains = new ArrayList<Train>() {
			{
				add(train1);
				add(train2);
				add(train3);
			}
		};
		
		CheminDeFer cheminDeFer = new CheminDeFer(trajets, trains);
		cheminDeFer.tour();
	}
}
