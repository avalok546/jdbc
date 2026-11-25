package Hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Hotelmodel {
	public void addHotel(HotelBean hotel) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			System.out.println("connectoin success");
			con.setAutoCommit(false);
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO hotel (Id, hotelName, hotelAddress, roomCount, rating)\r\n"
							+ "VALUES (?,?,?,?,?);");
			ps.setInt(1, hotel.getId());
			ps.setString(2, hotel.getHotelName());
			ps.setString(3, hotel.getHotelAddress());
			ps.setInt(4, hotel.getRoomCount());
			ps.setDouble(5, hotel.getRating());

			int i = ps.executeUpdate();

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

	// -------------------------delete----------------------------------------------------

	public void deleteHotel(HotelBean hotel) throws SQLException {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			System.out.println("connectoin success");
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement("delete from hotel where Id =?");
			ps.setInt(1, hotel.getId());

			int i = ps.executeUpdate();

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
//-------------------------update-------------------------------------------------
	
	public void updateHotel(HotelBean hotel) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			System.out.println("connectoin success");
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement("update hotel set hotelName = ?,hotelAddress = ?, roomCount = ?, rating = ? where Id = ?");
			ps.setString(1, hotel.getHotelName());
			ps.setString(2, hotel.getHotelAddress());
			ps.setInt(3, hotel.getRoomCount());
			ps.setDouble(4, hotel.getRating());
			ps.setInt(5, hotel.getId());

			int i = ps.executeUpdate();

			
			System.out.println("Record Upp");
			

			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			con.close();
		}
		
	}
}
