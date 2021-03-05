package jdbcproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.abc.util.DBUtil;

public class UpdateDemo {

	public static void main(String[] args) {
		
		Connection con = DBUtil.getDBConnection();
		
		String sql = "update product_tbl set price = 250000 where product_id = 103";
		
		try {
			
			Statement st = con.createStatement();
			int result = st.executeUpdate(sql);
			System.out.println("Rows updated: "+result);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DBUtil.closeDBConnection(con);
		}	

	}

}
