package bus_module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Delete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
		con.setAutoCommit(false);
		Statement stmt = con.createStatement();
		
		try {
			stmt.executeUpdate("delete from bus where id=1");
			
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













