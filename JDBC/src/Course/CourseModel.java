package Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseModel {
	public void add(CourseBean bean) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement("INSERT INTO course VALUES(?, ?, ?, ?, ?)");
			ps.setInt(1, bean.getCourseId());
			ps.setString(2, bean.getCourseName());
			ps.setInt(3, bean.getDuration());
			ps.setDouble(4, bean.getPrice());
			ps.setString(5, bean.getLevel());
			int i = ps.executeUpdate();
			con.commit();
			System.out.println("record inserted successfully");

		}

		catch (Exception e) {
			e.printStackTrace();
			con.rollback();

		} finally {
			con.close();
		}

	}
	// ---------------------------------------Delete-------------------------------------------------------

	public void delete(int courseId) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM course WHERE courseId = ?");

			pstmt.setInt(1, courseId);

			int i = pstmt.executeUpdate();

			conn.commit();
			System.out.println("record deleted successfully");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
	// ------------------------------------update------------------------------------------------------------

	public void update(CourseBean bean) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE course SET course Name = ?, duration = ?, price = ?, level = ? WHERE courseId = ?");

			ps.setString(1, bean.getCourseName());
			ps.setInt(2, bean.getDuration());
			ps.setDouble(3, bean.getPrice());
			ps.setString(4, bean.getLevel());
			ps.setInt(5, bean.getCourseId());

			int i = ps.executeUpdate();

			conn.commit();
			System.out.println("record updated successfully");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
	//-----------------------------------findByPk------------------------------------------
	public CourseBean findByPk(int courseId) throws SQLException {

		Connection conn = null;
		CourseBean bean = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM course WHERE courseId = ?");

			pstmt.setInt(1, courseId);

			ResultSet rs = pstmt.executeQuery();
		

			while (rs.next()) {
				System.out.println("record retrive");
				bean = new CourseBean();
				bean.setCourseId(rs.getInt("courseId"));
				bean.setCourseName(rs.getString("courseName"));
				bean.setDuration(rs.getInt("duration"));
				bean.setPrice(rs.getDouble("price"));
				bean.setLevel(rs.getString("level"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}


}
