package com.tactfactory.algotojava.tp17.database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

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
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rs;
	}
}
