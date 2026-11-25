package PreaperedStatement;

import java.sql.SQLException;

public class Banktest {
	public static void main(String[] args) throws SQLException {
//		testcreate();
//		testdatainserted();
//		testupdate();
		testdelete();
	}

	



	
//	private static void testcreate() throws SQLException {
//		Bank b = new Bank();
//		b.craetetable();
//		
//	}
	
//	private static void testdatainserted() throws SQLException {
//		Bank b = new Bank();
//		
//		b.insertdata(2, "Vijay Nagar", "Indore", "Rahul", "ABCHD0000002");
//		b.insertdata(3, "Palasia", "Indore", "Amit", "ABCHD0000003");
//		b.insertdata(4, "Bhopal Main", "Bhopal", "Priya", "ABCHD0000004");
//		b.insertdata(5, "Civil Lines", "Jabalpur", "Neha", "ABCHD0000005");
//		b.insertdata(6, "MG Road", "Pune", "Rohit", "ABCHD0000006");
//		b.insertdata(7, "Andheri", "Mumbai", "Pooja", "ABCHD0000007");
//		b.insertdata(8, "Connaught Place", "Delhi", "Karan", "ABCHD0000008");
	
//	private static void testupdate() {
//		Bank b = new Bank();
//		try {
//			b.updatedata(2, "Vijay Nagar", "Indore", "Rahul Sharma", "ABCHD0000002");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
	private static void testdelete() throws SQLException {
		Bank b= new Bank();
		b.delete(5);
		
	}
       		
	}

	
	
	
