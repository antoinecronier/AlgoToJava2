package com.tactfactory.algotojava.tp17.database.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp17.database.DBManager;
import com.tactfactory.algotojava.tp17.model.ArmePhysique;

public class ArmePhysiqueDB {

	private static final String INSERT = "INSERT INTO %s VALUES(%d,%d)";
	private static final String SELECT = "SELECT * FROM %s %s";
	private static final String TABLE = "ArmePhysique";
	private static final String ID = "id";
	private static final String WHERE_ID = "WHERE " + ID + " = %d";

	private ArmePhysique armePhysique;
	private DBManager manager = new DBManager();

	public ArmePhysique getArmePhysique() {
		return armePhysique;
	}

	public void setArmePhysique(ArmePhysique armePhysique) {
		this.armePhysique = armePhysique;
	}

	public ArmePhysique select(int id) {
		ArmePhysique result = new ArmePhysique();

		ResultSet rs = manager.selectRequest(String.format(SELECT, TABLE, String.format(WHERE_ID, id)));
		try {
			while (rs.next()) {
				result.setDegat(rs.getInt("degat"));
				result.setActionPoint(rs.getInt("actionPoint"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<ArmePhysique> select() {
		List<ArmePhysique> result = new ArrayList<ArmePhysique>();

		ResultSet rs = manager.selectRequest(String.format(SELECT, TABLE, ""));
		try {
			while (rs.next()) {
				result.add(new ArmePhysique(rs.getInt("degat"), rs.getInt("actionPoint")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public void insert(ArmePhysique armePhysique) {
		manager.creationRequest(String.format(INSERT, TABLE, armePhysique.getDegat(), armePhysique.getActionPoint()));
	}

	public void update(ArmePhysique armePhysique) {

	}

	public void delete(ArmePhysique armePhysique) {

	}
}
