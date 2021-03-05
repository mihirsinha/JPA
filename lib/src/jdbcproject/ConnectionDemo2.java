package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo2 {

	public static void main(String[] args) {

		Connection con = null;

		try {

			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded.");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "master");
			System.out.println("Connected.");			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null)
					con.close();
				System.out.println("connection closed.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
