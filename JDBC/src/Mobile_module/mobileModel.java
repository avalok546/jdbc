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
			PreparedStatement ps = conn.prepareStatement("INSERT INTO user VALUES(?, ?, ?, ?, ?, ?)");
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
			PreparedStatement ps = conn.prepareStatement("delete from mobile where id =?" );
			ps.setInt(1, bean.getId());
	
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
	public void update(mobileBean bean) throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("update mobile set brand =?, model= ?,battery= ?, operatingSystemString = ?  ");
			
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
	}public mobileBean findByPk(int id) throws SQLException {

		Connection conn = null;
		mobileBean bean = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user WHERE ID = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean.setId(id);
				bean.setBrand("lava");
				bean.setModel("new");
				bean.setBattery(95);
				bean.setOperatingSystemString("window");
				
				
				
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}

}
