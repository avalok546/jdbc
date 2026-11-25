package PreaperedStatement;


import java.sql.SQLException;

public class testuser {
	public static void main(String[] args) throws SQLException {
		
//			testcreate();
//			testinsert();
			testupdate();
		
	}

	
	
		
	

//	private static void testcreate() throws SQLException {
//		usermodel m = new usermodel();
//		m.createTable();
//		
//		
//	}
	
//	private static void testinsert() throws SQLException {
//		usermodel m = new usermodel();
//		m.insertdata(3, "arnav", "arnav@gmail.com");
//		m.insertdata(4, "test", "test@gmail.com");
//		m.insertdata(5, "java", "java@gmail.com");
//		m.insertdata(6, "python", "pythyon@gmail.com");
//		m.insertdata(7, "ramesh", "ramesh@gmail.com");
//		
//	
//	}
	
     private static void testupdate() throws SQLException {
    	 		usermodel m = new usermodel();
    	 		m.updatedata(4, "alok", "avalok545@gmail.com");
		
		
	}

	

}
