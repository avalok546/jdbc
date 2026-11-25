package RailwayBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
		Statement stmt = conn.createStatement()	;	
		int i = stmt.executeUpdate("create table railway(id int primary key, passangerName varchar(20), trainNo int, seatNo int,journeyDate varchar(20))");
		stmt.executeUpdate("insert into railway values(1,'Ravi', 1234, 12, '2024-06-15')");
		System.out.println(i+" table created");
		
		
		
	}

}
