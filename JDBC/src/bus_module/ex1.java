package bus_module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ex1 {
	//bus id int
	//bus number string
	//route string
	//capacity int
	//depurture time time
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load driver in jdbc
		Class.forName("com.mysql.cj.jdbc.Driver");
		//create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
		//connection auto commit false
		con.setAutoCommit(false);
		//create statement
		Statement stmt = con.createStatement();
//		stmt.executeUpdate("create table bus(id int primary key, number varchar(20), route varchar(20), capacity int, departure_time time)");
//		System.out.println("Table created successfully");
		try {
			stmt.executeUpdate("insert into bus values(1, 'KA-01-AB-1234', 'Route A', 50, '08:00:00')");
			stmt.executeUpdate("insert into bus values(2, 'KA-01-AB-5678', 'Route B', 40, '09:00:00')");
			stmt.executeUpdate("insert into bus values(3, 'KA-01-AB-9012', 'Route C', 60, '10:00:00')");
			stmt.executeUpdate("insert into bus values(4, 'KA-01-AB-3456', 'Route D', 55, '11:00:00')");
			stmt.executeUpdate("insert into bus values(5, 'KA-01-AB-7890', 'Route E', 45, '12:00:00')");
			stmt.executeUpdate("insert into bus values(6, 'KA-01-AB-2345', 'Route F', 70, '13:00:00')");
			stmt.executeUpdate("insert into bus values(7, 'KA-01-AB-6789', 'Route G', 65, '14:00:00')");
			con.commit();
		}
		catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}
	
	
	
	
}
