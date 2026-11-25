package RailwayBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insertandResultset extends Example1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
		Statement stmt = conn.createStatement()	;	
		
		
		
		stmt.executeUpdate("insert into railway values(5,'Ramesh', 1238, 16, '2024-06-19')");
		stmt.executeUpdate("insert into railway values(6,'Suresh', 1239, 17, '2024-06-20')");
		stmt.executeUpdate("insert into railway values(7,'Naresh', 1240, 18, '2024-06-21')");
		stmt.executeUpdate("insert into railway values(8,'Ganesh', 1241, 19, '2024-06-22')");
		stmt.executeUpdate("insert into railway values(9,'Rakesh', 1242, 20, '2024-06-23')");
		stmt.executeUpdate("insert into railway values(10,'Sandeep', 1243, 21, '2024-06-24')");
		
System.out.println("Record inserted");
		
		Statement stmt1 = conn.createStatement();
		java.sql.ResultSet rs = stmt1.executeQuery("select * from railway");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getString(5));
		}	
}
}