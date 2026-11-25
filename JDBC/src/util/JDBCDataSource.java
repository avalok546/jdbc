package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class JDBCDataSource {
	public static Connection getConnection() {
		ResourceBundle rb = ResourceBundle.getBundle("bundle.app");
		Connection con = null;
		try {
			Class.forName(rb.getString("driver"));
			con = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));

			System.out.println("connection done");

		} catch (Exception e) {
			e.printStackTrace();

		}
		return con;

	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	public static void trnRollback(Connection con) {
		if (con!=null) {
			try {
				con.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
