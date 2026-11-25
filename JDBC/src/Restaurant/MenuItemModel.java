package Restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuItemModel {
	public void addMenu(MenuBean menu) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			System.out.println("connectoion successfully");
			con.setAutoCommit(false);
			PreparedStatement psmt = con.prepareStatement(
					"INSERT INTO restuarant (itemId,itemName,category,price,isAbailavle" + ") VALUES (?, ?, ?,?,?)");
			psmt.setInt(1, menu.getItemId());
			psmt.setString(2, menu.getItemName());
			psmt.setString(3, menu.getCategory());
			psmt.setDouble(4, menu.getPrice());
			psmt.setBoolean(5, menu.isAbailavle());
			int i = psmt.executeUpdate();

			if (i > 0) {
				System.out.println("Record inserted");
			}

			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			con.close();
		}

	}
	// -----------------------------update------------------------------------------------------------

	public void updateMenu(MenuBean menu) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			System.out.println("connectoion successfully");
			con.setAutoCommit(false);
			PreparedStatement psmt = con.prepareStatement(
					"update restuarant set itemName=?,category=?,price=?,isAbailavle=?  where itemId=?");

			psmt.setString(1, menu.getItemName());
			psmt.setString(2, menu.getCategory());
			psmt.setDouble(3, menu.getPrice());
			psmt.setBoolean(4, menu.isAbailavle());
			psmt.setInt(5, menu.getItemId());
			int i = psmt.executeUpdate();

			System.out.println("Record update");

			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			con.close();
		}

	}
	// ------------------------------------------------------Delete----------------------------------------------------------------

	public void deleteMenu(MenuBean menu) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			System.out.println("connectoion successfully");
			con.setAutoCommit(false);
			PreparedStatement psmt = con.prepareStatement("delete from restuarant where itemId=?");

			psmt.setInt(1, menu.getItemId());
			int i = psmt.executeUpdate();

			System.out.println("Record update");

			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			con.close();
		}

	}
	// ---------------------------------------------------Search by
	// pk-------------------------------------------

	public void SearchByPk(MenuBean menu) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			System.out.println("connectoion successfully");
			con.setAutoCommit(false);
			PreparedStatement psmt = con.prepareStatement("SELECT * FROM restuarant  WHERE itemId = ?");

			psmt.setInt(1, menu.getItemId());
			ResultSet i = psmt.executeQuery();
			while (i.next()) {
				System.out.println(i.getInt(1));
				System.out.println(i.getString(2));
			}

			System.out.println("Record restuarant search by pk");

			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			con.close();
		}

	}

}
