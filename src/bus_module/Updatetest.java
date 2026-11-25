package bus_module;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Updatetest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
		con.setAutoCommit(false);
		
		Statement stmt = con.createStatement();
		
		try {
			stmt.executeUpdate("update bus set number='KA-01-AB-9999' where id=1");
			stmt.executeUpdate("update bus set route='Route Z' where id=2");
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
