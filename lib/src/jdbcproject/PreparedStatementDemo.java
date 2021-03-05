package jdbcproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.abc.util.DBUtil;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Product Id:");
		int pid = sc.nextInt();
		
		System.out.println("Enter Product Name:");
		String pname = sc.next();
		
		System.out.println("Enter Product Price:");
		double price = sc.nextDouble();
		
		sc.close();	
		
		Connection con = DBUtil.getDBConnection();

		String sql = "insert into product_tbl values(?,?,?)";

		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setDouble(3, price);
			
			int result = ps.executeUpdate();
			System.out.println("Rows added: "+result);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeDBConnection(con);
		}
	}

}
