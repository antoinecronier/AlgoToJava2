package com.tactfactory.algotojava.tp17.database.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tactfactory.algotojava.tp17.database.DBManager;
import com.tactfactory.algotojava.tp17.database.model.DBBaseItem;

public class DBItemManager<T extends DBBaseItem> {

	private static final String INSERT = "INSERT INTO %s(%s) VALUES(%s)";
	private static final String SELECT = "SELECT %s FROM %s %s";
	private static final String WHERE_ID = "WHERE %s = %s";
	
	private DBManager manager = new DBManager();
	private DBBaseItem baseItem;
	
	public DBItemManager(DBBaseItem baseItem) {
		super();
		this.baseItem = baseItem;
		if (!checkTableExists()) {
			create();
		}
	}

	public T select(int id){
		T result = (T) baseItem;

		ResultSet rs = manager.selectRequest(String.format(SELECT, baseItem.TABLE, String.format(WHERE_ID,baseItem.ID, id)));
		try {
			while (rs.next()) {
				result = (T) result.parseIn(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public List<T> select(){
		List<T> result = new ArrayList<>();

		ResultSet rs = manager.selectRequest(String.format(SELECT, "*", baseItem.TABLE, ""));
		try {
			while (rs.next()) {
				result.add((T) baseItem.parseIn(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public void insert(){
		manager.creationRequest(String.format(INSERT, baseItem.TABLE,baseItem.getFields(), baseItem.parseOut(baseItem.getItem())));
	}
	
	public void update(T item){
		
	}
	
	public void delete(T item){
		
	}
	
	public void create(){
		manager.creationRequest(baseItem.getSchema());
	}
	
	public boolean checkTableExists(){
		boolean result = false;
		for (String name : manager.selectRequestStrings("SHOW TABLES")) {
			if (name.equals(baseItem.TABLE)) {
				result = true;
				break;
			}
		}
		return result;
	}
}
