package com.tactfactory.algotojava.tp17.database.model;

import java.sql.ResultSet;
import com.tactfactory.algotojava.tp17.model.ArmePhysique;

public class ArmePhysiqueDB extends DBBaseItem {

	private static final String TABLE = "ArmePhysique";
	private static final String ID = "id";
	private static final String[][] FIELDS = { { "degat", "INT NOT NULL" }, { "actionPoint", "INT NOT NULL" } };

	private ArmePhysique armePhysique;

	public ArmePhysique getArmePhysique() {
		return armePhysique;
	}

	public void setArmePhysique(ArmePhysique armePhysique) {
		this.armePhysique = armePhysique;
	}

	@Override
	public ArmePhysique getItem() {
		// TODO Auto-generated method stub
		return this.getArmePhysique();
	}

	public ArmePhysiqueDB() {
		super(TABLE, ID);
	}

	@Override
	public ArmePhysiqueDB parseIn(ResultSet rs) {
		ArmePhysique result = new ArmePhysique();
		try {
			while (rs.next()) {
				result.setDegat(rs.getInt("degat"));
				result.setActionPoint(rs.getInt("actionPoint"));
			}
		} catch (Exception e) {
		}
		this.armePhysique = result;
		return this;
	}

	@Override
	public String parseOut(Object item) {
		return ((ArmePhysique)item).getDegat() + "," + ((ArmePhysique)item).getActionPoint();
	}

	@Override
	public String getSchema() {
		return "CREATE TABLE " + TABLE + " ("  
				+ ID + " INT AUTO_INCREMENT PRIMARY KEY NOT NULL," 
				+ FIELDS[0][0] + " " + FIELDS[0][1] + ","
				+ FIELDS[1][0] + " " + FIELDS[1][1] + ""
				+ ")";
	}

	@Override
	public String getFields() {
		String result = "";
		int i = 0;
		for (; i < FIELDS.length-1; i++) {
			result += FIELDS[i][0] + ",";
		}
		result += FIELDS[i][0];
		return result;
	}
}
