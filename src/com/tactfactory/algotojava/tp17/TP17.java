package com.tactfactory.algotojava.tp17;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tactfactory.algotojava.tp17.database.DBManager;
import com.tactfactory.algotojava.tp17.database.DBOpenHelper;
import com.tactfactory.algotojava.tp17.database.model.ArmePhysiqueDB;
import com.tactfactory.algotojava.tp17.manager.Combat;
import com.tactfactory.algotojava.tp17.manager.PersonnageBuilder;
import com.tactfactory.algotojava.tp17.model.ArmePhysique;
import com.tactfactory.algotojava.tp17.model.Personnage;
import com.tactfactory.algotojava.tp17.model.rpg.Barbare;
import com.tactfactory.algotojava.tp17.model.rpg.defaultclasse.DefaultBarbare;
import com.tactfactory.algotojava.tp17.model.rpg.defaultclasse.DefaultMage;
import com.tactfactory.algotojava.tp17.model.rpg.defaultclasse.DefaultPaladin;

public class TP17 {

	public static void main(String[] args) {
		DBOpenHelper.getInstance();
		DBManager manager = new DBManager();
		
		ArmePhysiqueDB apDB = new ArmePhysiqueDB();
		apDB.insert(new ArmePhysique(3, 2));
		//do1(manager);

		try {
			DBOpenHelper.getInstance().getConn().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void do1(DBManager manager) {
		System.out.println(manager.selectRequest("SHOW TABLES"));

		manager.creationRequest("DELETE FROM User");
		manager.creationRequest("DELETE FROM Role");
		manager.creationRequest("ALTER TABLE User AUTO_INCREMENT = 0");
		manager.creationRequest("ALTER TABLE Role AUTO_INCREMENT = 0");

		for (int i = 1; i <= 20; i++) {
			manager.creationRequest("INSERT INTO User VALUES(" + i + ",'" + "User" + i + "',NULL)");
		}

		for (int i = 1; i <= 3; i++) {
			manager.creationRequest("INSERT INTO Role VALUES(" + i + ",'" + "Role" + i + "')");
		}

		for (int i = 1; i <= 20; i++) {
			manager.creationRequest("UPDATE User SET id_Role = '" + ((i % 3)+1) + "' WHERE User.id = " + i);
		}

		System.out.println(manager.selectRequest("SELECT * FROM User"));
		System.out.println(manager.selectRequest("SELECT * FROM Role"));
		System.out.println(manager.selectRequest("SELECT * FROM User INNER JOIN Role ON User.id_Role = Role.id ORDER BY User.id"));
	}

	public static void setUp() {
		PersonnageBuilder builder = new PersonnageBuilder();

		Personnage paladin = builder.setName("paladin").setDefaultHero(new DefaultPaladin()).build();
		builder = new PersonnageBuilder();

		Personnage barbare = builder.setName("barbare").setDefaultHero(new DefaultBarbare()).build();
		((Barbare) barbare.getClasse()).setSecondaryWeapon(new ArmePhysique(3, 2));
		builder = new PersonnageBuilder();

		Personnage mage = builder.setName("mage").setDefaultHero(new DefaultMage()).build();
		builder = new PersonnageBuilder();

		Personnage mob1 = builder.setName("mob1").build();
		builder = new PersonnageBuilder();

		Personnage mob2 = builder.setName("mob2").build();
		builder = new PersonnageBuilder();

		Personnage mob3 = builder.setName("mob3").build();
		builder = new PersonnageBuilder();

		Combat combat = new Combat(new ArrayList<Personnage>() {
			{
				add(paladin);
				add(barbare);
				add(mage);
			}
		}, new ArrayList<Personnage>() {
			{
				add(mob1);
				add(mob2);
				add(mob3);
			}
		});
		combat.fightNoBack();
	}
}
