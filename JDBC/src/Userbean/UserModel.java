package Userbean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

	public int add(UserBean bean) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user VALUES(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

			int i = pstmt.executeUpdate();

			conn.commit();
			System.out.println("record inserted successfully");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean.getId();

	}

	public void delete(int id) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM user WHERE ID = ?");

			pstmt.setInt(1, id);

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

	public void update(UserBean bean) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE user SET FIRSTNAME = ?, LASTNAME = ?, LOGIN = ?, PASSWORD = ?, DOB = ? WHERE ID = ?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLogin());
			pstmt.setString(4, bean.getPassword());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setInt(6, bean.getId());

			int i = pstmt.executeUpdate();

			conn.commit();
			System.out.println("record updated successfully");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

	public UserBean findByPk(int id) throws SQLException {

		Connection conn = null;
		UserBean bean = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user WHERE ID = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setLogin(rs.getString("login"));
				bean.setPassword(rs.getString("password"));
				bean.setDob(rs.getDate("dob"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}

	public UserBean findByLogin(String login) throws SQLException {

		Connection conn = null;
		UserBean bean = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user WHERE LOGIN = ?");

			pstmt.setString(1, login);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setLogin(rs.getString("login"));
				bean.setPassword(rs.getString("password"));
				bean.setDob(rs.getDate("dob"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}

	public UserBean authenticate(String login, String password) throws SQLException {

		UserBean bean = findByLogin(login);

		if (bean != null && bean.getPassword().equals(password)) {
			return bean;
		}

		return null;

	}

	public List<UserBean> search(UserBean bean, int pageNo, int pageSize) throws SQLException {
		Connection con = null;
		List<UserBean> list = new ArrayList<UserBean>();
		StringBuffer sql = new StringBuffer("select * from user where 1=1");
		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append("and id = " + bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" AND firstName LIKE '%" + bean.getFirstName() + "%'");

			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" AND lastName LIKE '%" + bean.getLastName() + "%'");

			}
			if (bean.getLogin() != null && bean.getLogin().length() > 0) {
				sql.append("and login =" + bean.getLogin());

			}
			if (pageSize > 0) {
				int index = (pageNo - 1) * pageSize;

				sql.append(" LIMIT " + pageSize + " OFFSET " + index);
			}
			System.out.println(sql);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
				PreparedStatement ps = con.prepareStatement(sql.toString());
				ResultSet rs = ps.executeQuery();
				System.out.println("done");
				while (rs.next()) {
					bean = new UserBean();
					bean.setId(rs.getInt("id"));
					bean.setFirstName(rs.getString("firstName"));
					bean.setLastName(rs.getString("lastName"));
					bean.setLogin(rs.getString("login"));
					bean.setPassword(rs.getString("password"));
					bean.setDob(rs.getDate("dob"));
					list.add(bean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		return list;
		
	}

}