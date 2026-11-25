package Library;

import java.sql.SQLException;

public class Testbookmodel {
	public static void main(String[] args) throws SQLException {
		testadd();
		testupdate();
		testdelete();
	}

	private static void testdelete() {
		// TODO Auto-generated method stub
		Bookmodel model = new Bookmodel();
		Userbean bean = new Userbean();
		bean.setBookid(1);
		try {
			model.delete(bean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void testadd() throws SQLException {
		// TODO Auto-generated method stub
		Bookmodel model = new Bookmodel();
		Userbean bean = new Userbean();
		bean.setBookid(5);
		bean.setTitle(" html  Programming");
		bean.setAuthor("ramesh Doe");
		bean.setPrice(139.99);
		bean.setavailability(true);
		model.add(bean);
	}
	private static void testupdate() {
		// TODO Auto-generated method stub
		Bookmodel model = new Bookmodel();
		Userbean bean = new Userbean();
		bean.setBookid(1);
		bean.setTitle("Advanced Java Programming");
		bean.setAuthor("Jane Smith");
		
		try {
			model.update(bean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
