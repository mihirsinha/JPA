package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecordDemo {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded.");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "master");
			System.out.println("Connected.");	
			
			String sql = "insert into product_tbl values(103,'tablet',30000)";
			
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			System.out.println("Rows effected: "+result);
			System.out.println("Product inserted...");		
			
			
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
