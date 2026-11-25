package Hotel;

import java.sql.SQLException;

public class TestHotelModule {
	public static void main(String[] args) throws SQLException {
		//testadd();
		//testdelete();
		//testUpdate();
		
	}

	private static void testUpdate() throws SQLException {
		Hotelmodel m  = new Hotelmodel();
		HotelBean hotel = new HotelBean();
		hotel.setId(3);
		hotel.setHotelName("alokhomes");
		m.updateHotel(hotel);
		
		

		
	}

	private static void testdelete() throws SQLException {
		Hotelmodel m  = new Hotelmodel();
		HotelBean hotel = new HotelBean();
		hotel.setId(3);
		
		
		m.deleteHotel(hotel);
		
		
	}

	private static void testadd() throws SQLException {
		Hotelmodel m  = new Hotelmodel();
		HotelBean hotel = new HotelBean();
		hotel.setId(4);
		hotel.setHotelName("nihalhotel");
		hotel.setHotelAddress("rajsthan");
		hotel.setRoomCount(28);
		hotel.setRating(4.5);
		
		m.addHotel(hotel);
		
	}

}
