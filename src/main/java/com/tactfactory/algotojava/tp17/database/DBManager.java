package com.tactfactory.algotojava.tp17.database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

	public DBManager() {

	}

	public String creationRequest(String request) {
		StringBuilder result = new StringBuilder();

		Statement stmt = null;

		try {
			stmt = DBOpenHelper.getInstance().getConn().createStatement();
			result.append(stmt.executeUpdate(request));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result.toString();
	}

	public ResultSet selectRequest(String request) {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = DBOpenHelper.getInstance().getConn().createStatement();
			rs = stmt.executeQuery(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public List<String> selectRequestStrings(String request) {
		List<String> result = new ArrayList<String>();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = DBOpenHelper.getInstance().getConn().createStatement();
			rs = stmt.executeQuery(request);
			while (rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					result.add(rs.getString(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
