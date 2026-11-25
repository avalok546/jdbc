package PreaperedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bank {

	// ------------------------create
	// table--------------------------------------------------------------
	public void craetetable() throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(
					"create table bank(id int primary key, branchName varchar(45), cityName varchar(45), managerName varchar(45), ifsc varchar(45))");
			pstmt.executeUpdate();
			System.out.println("table is craeted");
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.fillInStackTrace();
		} finally {
			con.close();
		}
	}

	// -------------------------insert
	// data--------------------------------------------------------------------
	public void insertdata(int id, String branchName, String city, String managerName, String ifsc)
			throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("insert into bank values(?,?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, branchName);
			pstmt.setString(3, city);
			pstmt.setString(4, managerName);
			pstmt.setString(5, ifsc);
			pstmt.executeUpdate();
			System.out.println("data inserted");
			con.commit();
			;

		} catch (Exception e) {
			con.rollback();

		}

	}
	
	// -------------------------update data--------------------------------------------------------------------
		public void updatedata(int id, String branchName, String city, String managerName, String ifsc)
				throws SQLException {
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

				con.setAutoCommit(false);
				PreparedStatement pstmt = con.prepareStatement("update bank set branchName=?, cityName=?, managerName=?, ifsc=? where id=?");
				pstmt.setString(1, branchName);
				pstmt.setString(2, city);
				pstmt.setString(3, managerName);
				pstmt.setString(4, ifsc);
				pstmt.setInt(5, id);
			
				pstmt.executeUpdate();
				System.out.println("data updated");
				con.commit();
				;

			} catch (Exception e) {
				con.rollback();

			}

		}
		
	
		// -------------------------delete data--------------------------------------------------------------------
		public void delete(int id)
				throws SQLException {
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

				con.setAutoCommit(false);
				PreparedStatement pstmt = con.prepareStatement("delete from bank where id=?");
				pstmt.setInt(1, id);
				
				pstmt.executeUpdate();
				System.out.println("data deleted");
				con.commit();
				;

			} catch (Exception e) {
				con.rollback();

			}

		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
