package onlineShoping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1 {
	public static void main(String [] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
		Statement stmt = conn.createStatement()	;
		int i = stmt.executeUpdate("create table onlineShoping(product_id int primary key, productName varchar(20), price int, category varchar(20), stock int)");
		System.out.println("Table created successfully");
	}
}
