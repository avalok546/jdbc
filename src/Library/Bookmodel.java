package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bookmodel {
	// ---------------------ADD--------------------------------------------------------------

	public void add(Userbean bean) throws SQLException {
		Connection con = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"insert into library (bookid, title, author, price, availability) values (?, ?, ?, ?, ?)");
			ps.setInt(1, bean.getBookid());
			ps.setString(2, bean.getTitle());
			ps.setString(3, bean.getAuthor());
			ps.setDouble(4, bean.getPrice());
			ps.setBoolean(5, bean.isavailability());
			int Result = ps.executeUpdate();
			con.commit();

			if (Result > 0) {
				System.out.println("Book inserted successfully");
			}
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();

		}

	}

	// ---------------------------------------------------------------------------------------------------------------------
	public void update(Userbean bean) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"update library Set title = ?, author = ?, price = ?, availability = ? where bookid = ? ");
			ps.setString(1, bean.getTitle());
			ps.setString(2, bean.getAuthor());
			ps.setDouble(3, bean.getPrice());
			ps.setBoolean(4, bean.isavailability());
			ps.setInt(5, bean.getBookid());
			int result = ps.executeUpdate();
			con.commit();
			System.out.println(result + " row(s) updated");
			System.out.println("Book updated successfully");
			ps.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			con.rollback();
		}

	}
	
	//------------------------------------delete-------------------------------------------------------------
	
	
	public void delete(Userbean bean) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement("delete from library where bookid = ?");
			ps.setInt(1, bean.getBookid());
			int result = ps.executeUpdate();
			con.commit();
			System.out.println("Book deleted successfully");
			ps.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			con.rollback();
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
