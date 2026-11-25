package PreaperedStatement;

import java.sql.SQLException;

public class marksTest {
	public static void main(String[] args) throws Exception {
		
//		testcreatetable();
//		testinsertdata();
//		testupdatedata();
//		testdelete();
		
	}
                       
						//--------create table----------------
//	private static void testcreatetable() throws SQLException {
//		marks m = new marks();
//		m.createTable();
//	}
                          //----------------insert data----------------

	

//	private static void testinsertdata() {
//		 marks m = new marks();
//		try {
//			m.insertdata(1, 101, "Ravi", 80, 90, 70);
//			m.insertdata(2, 102, "Ramesh", 60, 70, 80);
//			m.insertdata(3, 103, "Suresh", 90, 80, 70);
//			m.insertdata(4, 104, "Mahesh", 70, 60, 80);
//			m.insertdata(5, 105, "Rajesh", 80, 90, 70);
//			m.insertdata(6, 106, "Rakesh", 60, 70, 80);
//			m.insertdata(7, 107, "Ramesh", 90, 80, 70);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	//-------------update table--------------------------------------------------------
//	private static void testupdatedata() throws SQLException {
//		marks m = new marks();
//		m.updatedata(1, 101, "av", 80, 90, 70);
//		
//	}
	
	   private static void testdelete() throws SQLException {
			marks m = new marks();
			m.deletedata(4);
			
		}
	
	

}
