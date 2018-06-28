package com.tactfactory.algotojava.tp17.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tactfactory.algotojava.tp17.model.ArmeMagique;
import com.tactfactory.algotojava.tp17.model.ArmeMixte;
import com.tactfactory.algotojava.tp17.model.ArmePhysique;
import com.tactfactory.algotojava.tp17.model.ArmureMagique;
import com.tactfactory.algotojava.tp17.model.ArmureMixte;
import com.tactfactory.algotojava.tp17.model.ArmurePhysique;
import com.tactfactory.algotojava.tp17.model.Butin;

public class LootGenerator {

	public static List<Butin> generateLoots() {
		List<Butin> result = new ArrayList<Butin>();

		Random rand = new Random();
		int generateItems = rand.nextInt(100) % 100;
		int itemToGenerate = 0;

		if (generateItems > 80) {
			itemToGenerate = 3;
		} else if (generateItems > 50) {
			itemToGenerate = 2;
		} else if (generateItems > 20) {
			itemToGenerate = 1;
		}

		for (int i = 0; i < itemToGenerate; i++) {
			Butin item = null;
			int butinType = rand.nextInt(6) % 6;
			switch (butinType) {
			case 0:
				item = new ArmePhysique(rand.nextInt(4), rand.nextInt(6));
				break;
			case 1:
				item = new ArmurePhysique(rand.nextInt(3));
				break;
			case 2:
				item = new ArmeMagique(rand.nextInt(4), rand.nextInt(6));
				break;
			case 3:
				item = new ArmureMagique(rand.nextInt(3));
				break;
			case 4:
				item = new ArmeMixte(new ArmePhysique(rand.nextInt(4), rand.nextInt(6)),
						new ArmeMagique(rand.nextInt(4), rand.nextInt(6)));
				break;
			case 5:
				item = new ArmureMixte(new ArmureMagique(rand.nextInt(3)), new ArmurePhysique(rand.nextInt(3)));
				break;
			}
		}

		return result;
	}
}
