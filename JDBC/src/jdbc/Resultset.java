package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Resultset {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
		System.out.println("Connection Established"+ con.getCatalog());
		
		Statement stmt = con.createStatement();
		
		// for searching the data from the table we use ResultSet interface
		
		ResultSet rs = stmt.executeQuery("select * from school");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			
		
		}
		// for updating the data in the table we use executeUpdate() method of Statement interface
		
		
		
	}

}
