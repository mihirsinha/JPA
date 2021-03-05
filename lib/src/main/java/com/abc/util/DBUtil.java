package com.abc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String driverName = "org.postgresql.Driver";
	private static final String url = "jdbc:postgresql://localhost:5432/testdb";
	private static final String username ="postgres";
	private static final String password="master";
	
	public static Connection getDBConnection() {
		
		Connection con = null;
		
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, username, password);			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeDBConnection(Connection con) {
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
