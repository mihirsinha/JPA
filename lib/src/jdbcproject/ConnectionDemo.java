package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//step 1: load the driver and register with DriverManger
        Class.forName("org.postgresql.Driver");
        System.out.println("Driver loaded.");
        
        //step 2: establish connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","master");
        System.out.println("Connected.");

      	//step 3: perform db operations
         //Using Statement object we can perform db operation

        //step 4: close the connection
        con.close();
        System.out.println("connection closed.");
        

	}

}
