package PreaperedStatement;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class usermodel {
	//--------------------------CREATE TABLE--------------------------

	public void createTable() throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("create table user (id int primary key, name varchar(20), email varchar(20))");
			pstmt.executeUpdate()
;
			
			System.out.println("table created succefully");
			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}

	}
	
	
	//-------------------------INSERT DATA--------------------------
	public void insertdata(int id, String name, String email) throws SQLException{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("insert into user values(?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.executeUpdate();
			con.commit();
				
		}
		catch(Exception e) {
			e.printStackTrace();
			con.rollback();
		}
		finally {
			con.close();
		}
		
	}
	
	//-------------------------UPDATE DATA--------------------------
	public void updatedata(int id, String name, String email) throws SQLException{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("update user set name=?, email=? where id=?");
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
			con.commit();
				
		}
		catch(Exception e) {
			e.printStackTrace();
			con.rollback();
		}
		finally {
			con.close();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
