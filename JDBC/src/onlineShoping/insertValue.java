package onlineShoping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insertValue {
	public static void main(String [] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
		Statement stmt = conn.createStatement()	;
		stmt.executeUpdate("insert into onlineShoping values(1,'Mobile',20000,'Electronics',10)");
		stmt.executeUpdate("insert into onlineShoping values(2,'Laptop',50000,'Electronics',5)");
		stmt.executeUpdate("insert into onlineShoping values(3,'Shirt',1000,'Clothing',20)");
		stmt.executeUpdate("insert into onlineShoping values(4,'Shoes',3000,'Footwear',15)");
		stmt.executeUpdate("insert into onlineShoping values(5,'Watch',5000,'Accessories',8)");
		stmt.executeUpdate("insert into onlineShoping values(6,'Headphones',1500,'Electronics',12)");
		stmt.executeUpdate("insert into onlineShoping values(7,'Bag',2000,'Accessories',10)");
		
		System.out.println("Values inserted successfully");
		
		
	}}