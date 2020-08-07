package com.tactfactory.algotojava.tp17.database;

import java.sql.Connection;
import java.sql.SQLException;

//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBOpenHelper {

  private Connection conn = null;

  /** Constructeur privé */
  private DBOpenHelper() {
//		MysqlDataSource dataSource = new MysqlDataSource();
//		dataSource.setUser("root");
//		dataSource.setPassword("root");
//		dataSource.setServerName("127.0.0.1");
//		dataSource.setDatabaseName("TP17");
//		try {
//			dataSource.setServerTimezone("UTC");
//			conn = dataSource.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
  }

  /** Instance unique non préinitialisée */
  private static DBOpenHelper INSTANCE = null;

  /** Point d'accès pour l'instance unique du DBOpenHelper */
  public static DBOpenHelper getInstance() {
    if (INSTANCE == null) {
      synchronized (DBOpenHelper.class) {
        if (INSTANCE == null) {
          INSTANCE = new DBOpenHelper();
        }
      }
    }
    return INSTANCE;
  }

  public Connection getConn() {
    return conn;
  }
}
