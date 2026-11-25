package Restaurant;

import java.sql.SQLException;

public class TestMenu {
	public static void main(String[] args) throws SQLException {
		//testinsert();
		//testUpdate();
		//testDelete();
		searchbypk();
	}

	private static void searchbypk() throws SQLException {
		MenuItemModel m = new MenuItemModel();
		MenuBean mb = new MenuBean();
		mb.setItemId(4);
		m.SearchByPk(mb);
		
	}

	private static void testDelete() throws SQLException {
		MenuItemModel m = new MenuItemModel();
		MenuBean mb = new MenuBean();
		mb.setItemId(3);
		m.deleteMenu(mb);

	}

	private static void testUpdate() throws SQLException {
		MenuItemModel m = new MenuItemModel();
		MenuBean mb = new MenuBean();
		mb.setItemId(3);
		mb.setPrice(149);
		
		m.updateMenu(mb);
		
	}

	private static void testinsert() throws SQLException {
		MenuItemModel m = new MenuItemModel();
		MenuBean mb = new MenuBean();
		mb.setItemId(6);
		mb.setItemName("idli");
		mb.setCategory(" south indian");
		mb.setPrice(149);
		mb.setisAbailavle(true);
		m.addMenu(mb);
	}

}
