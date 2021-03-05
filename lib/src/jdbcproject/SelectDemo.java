package jdbcproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abc.util.DBUtil;

public class SelectDemo {

	public static void main(String[] args) {

		Connection con = DBUtil.getDBConnection();

		String sql = "select price,name from product_tbl";

		try {

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				String name = rs.getString("name");
				double price = rs.getDouble("price");

				System.out.println(name + "  " + price);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeDBConnection(con);
		}

	}

}
