package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class testdelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
		System.out.println("Connection Established"+ con.getCatalog());
		
		Statement stmt = con.createStatement();
		
		int i = stmt.executeUpdate("delete from school where id=1");
		System.out.println(i+" record deleted");
	}

}
