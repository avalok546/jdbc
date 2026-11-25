package util;

import java.sql.Connection;

public class test {
	public static void main(String[] args) {
		
		Connection con = null;
		 con = JDBCDataSource.getConnection();
	}

}
