package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;


public class Experince {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
		System.out.println("Connection Established"+ con.getCatalog());
		
		Statement stmt = con.createStatement();
		
		// for searching the data from the table we use ResultSet interface
		
		
		// for updating the data in the table we use executeUpdate() method of Statement interface
		
		
		
	}

	

}
