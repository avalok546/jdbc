package Userbean;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) {

		try {
			// testAdd();
//			testDelete();
//			testUpdate();
			testFindByPk();
//			testauthenticate();
			// testFindbylogin();
			//testSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(8);
		bean.setFirstName("Chintu");
		bean.setLastName("Chokshe");
		bean.setLogin("chintu@gmail.com");
		bean.setPassword("pass123");
		bean.setDob(sdf.parse("2003-01-01"));

		model.add(bean);

	}

	public static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(8);

	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(9);
		bean.setFirstName("Chintu");
		bean.setLastName("Chokshe");
		bean.setLogin("chintu@gmail.com");
		bean.setPassword("pass123");
		bean.setDob(sdf.parse("2003-01-01"));

		model.update(bean);

	}

	public static void testFindByPk() throws SQLException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByPk(1);

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		} else {
			System.out.println("user not found");
		}

	}

	private static void testauthenticate() throws SQLException {
		UserModel model = new UserModel();

		UserBean bean = model.authenticate("rahul@gmail.com", "rahul123");

		if (bean != null) {

			System.out.println("Login Successfully");
			System.out.println("ID: " + bean.getId());
			System.out.println("First Name: " + bean.getFirstName());
			System.out.println("Last Name: " + bean.getLastName());
			System.out.println("Login: " + bean.getLogin());
			System.out.println("DOB: " + bean.getDob());

		} else {

			System.out.println("Invalid Login or Password");

		}

	}

	private static void testFindbylogin() throws SQLException {
		UserModel m = new UserModel();
		UserBean bean = new UserBean();
		m.findByLogin("priya@gmail.com");
		if (bean != null) {

			System.out.println("Login Successfully");
			System.out.println("ID: " + bean.getId());
			System.out.println("First Name: " + bean.getFirstName());
			System.out.println("Last Name: " + bean.getLastName());
			System.out.println("Login: " + bean.getLogin());
			System.out.println("DOB: " + bean.getDob());

		}

	}

	private static void testSearch() throws SQLException {

		UserModel m = new UserModel();
		UserBean bean = new UserBean();
		bean.setFirstName("a");
		List<UserBean> list = m.search(bean, 1, 5);
		Iterator<UserBean> it = list.iterator();
		while (it.hasNext()) { 
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			
		}

	}

}