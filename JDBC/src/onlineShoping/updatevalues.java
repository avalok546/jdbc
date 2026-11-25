package onlineShoping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class updatevalues {
	public static void main(String [] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
		Statement stmt = conn.createStatement()	;
		stmt.executeUpdate("update onlineShoping set price=25000 where product_id=1");
		System.out.println("Values updated successfully");
}}