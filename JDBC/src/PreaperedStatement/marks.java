package PreaperedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class marks {
	
	           //--------------------------CREATE TABLE--------------------------
		
		public void createTable() throws SQLException {
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
				con.setAutoCommit(false);
				PreparedStatement pstmt = con.prepareStatement("create table marks (id int primary key,  roll_num int, name varchar(20), pysics int, chemistry int, maths int)");
				pstmt.executeUpdate();
				System.out.println("table created succefully");
				con.commit();
				
				
			}
		    catch(Exception e) {
		    	e.printStackTrace();
		    	
		    }
			finally {
				con.close();
			}

}
		
		//-------------------------INSERT DATA--------------------------
		public  void insertdata(int id, int roll_num, String name, int pysics, int chemistry, int maths) throws SQLException{
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
				con.setAutoCommit(false);
				PreparedStatement pstmt = con.prepareStatement("insert into marks values(?,?,?,?,?,?)");
				pstmt.setInt(1, id);
				pstmt.setInt(2, roll_num);
				pstmt.setString(3, name);
				pstmt.setInt(4, pysics);
				pstmt.setInt(5, chemistry);
				pstmt.setInt(6, maths);
				pstmt.executeUpdate();
				System.out.println("data inserted succefully");
				con.commit();
				
			}
			catch(Exception e) {
		    	e.printStackTrace();
		    	
		    }
			finally {
				con.close();
			}
		}
			//-------------------------UPDATE DATA--------------------------
			public void updatedata(int id, int roll_num, String name, int pysics, int chemistry, int maths) throws SQLException {
				Connection con = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
					con.setAutoCommit(false);
					PreparedStatement pstmt = con.prepareStatement(
						    "UPDATE marks SET roll_num=?, name=?, pysics=?, chemistry=?, maths=? WHERE id=?"
						);
					pstmt.setInt(1, roll_num);
					pstmt.setString(2, name);
					pstmt.setInt(3, pysics);
					pstmt.setInt(4, chemistry);
					pstmt.setInt(5, maths);
					pstmt.setInt(6, id);
					pstmt.executeUpdate();
					System.out.println("data updated succefully");
					con.commit();
					
			}
				catch(Exception e) {
			    	e.printStackTrace();
			    	con.rollback();
			    	
			    }
				finally {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			
			
		}
		
		public void deletedata(int id) throws SQLException {
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
				con.setAutoCommit(false);
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM marks WHERE id = ?;");
				pstmt.setInt(1, id);
				pstmt.executeUpdate();		
				con.commit();
				System.out.println("record deleted suceecfully");
			}
			catch(Exception e) {
		    	e.printStackTrace();
		    	con.rollback();
		    	
		    }
			finally {
				con.close()
;			}
		
		}
			
		
		
		
}
		
		
		
		
		
		
