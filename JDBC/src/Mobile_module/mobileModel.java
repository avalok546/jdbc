package Mobile_module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.BlobFromLocator;

import Userbean.UserBean;

public class mobileModel {
	public void add(mobileBean bean) throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO mobile VALUES(?, ?, ?, ?, ?)");
			ps.setInt(1, bean.getId());
			ps.setString(2, bean.getBrand());
			ps.setString(3, bean.getModel());
			ps.setInt(4, bean.getBattery());
			ps.setString(5, bean.getOperatingSystemString());
			int i = ps.executeUpdate();

			conn.commit();
			System.out.println("record inserted successfully");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public void delete(mobileBean bean) throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("delete from mobile where mobileid =?");
			ps.setInt(1, bean.getId());

			int i = ps.executeUpdate();

			conn.commit();
			System.out.println("record deleted successfully");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public void update(mobileBean bean, int mobileid) throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(
					"update mobile set brand =?, model= ?,battery= ?, operatingSystem = ? where mobileid=? ");

			ps.setString(1, bean.getBrand());
			ps.setString(2, bean.getModel());
			ps.setInt(3, bean.getBattery());
			ps.setString(4, bean.getOperatingSystemString());
			ps.setInt(5, bean.getId());
			int i = ps.executeUpdate();

			conn.commit();
			System.out.println("record inserted successfully");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public mobileBean findByPk(int id) throws SQLException {

		Connection conn = null;
		mobileBean bean = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM mobile WHERE mobileId = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				bean = new mobileBean();

				bean.setId(rs.getInt("mobileId"));
				bean.setBrand(rs.getString("brand"));
				bean.setModel(rs.getString("model"));
				bean.setBattery(rs.getInt("battery"));
				bean.setOperatingSystemString(rs.getString("operatingSystem"));
				System.out.println("hello");
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (conn != null) {
				conn.close();
			}
		}
		return bean;

	}

}
