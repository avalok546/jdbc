package Mobile_module;

import java.sql.SQLException;

import jdbc.testUpdate;

public class testMobile {
	public static void main(String[] args) throws SQLException {
		// testadd();
		// testdelete();
		// testupdate();
		testfindByPk();

	}

	private static void testadd() throws SQLException {
		mobileModel m = new mobileModel();
		mobileBean bean = new mobileBean();
		bean.setId(22);
		bean.setBrand("lava");
		bean.setBattery(99);
		bean.setModel("new");
		bean.setOperatingSystemString("window");
		m.add(bean);

	}

	private static void testdelete() throws SQLException {
		mobileModel m = new mobileModel();
		mobileBean bean = new mobileBean();
		bean.setId(22);
		m.delete(bean);

	}

	private static void testupdate() throws SQLException {
		mobileModel m = new mobileModel();
		mobileBean bean = new mobileBean();
		bean.setBattery(100);

		m.update(bean, 9);

	}

	private static void testfindByPk() throws SQLException {

		mobileModel m = new mobileModel();

		mobileBean bean = m.findByPk(9);

		if (bean != null) {

			System.out.println("ID: " + bean.getId());
			System.out.println("Brand: " + bean.getBrand());
			System.out.println("Model: " + bean.getModel());
			System.out.println("Battery: " + bean.getBattery());
			System.out.println("Operating System: " + bean.getOperatingSystemString());

		} else {

			System.out.println("Mobile record not found");
		}
	}

}
