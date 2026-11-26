package HospitalUsingResourceBundle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Mobile_module.mobileBean;
import Userbean.UserBean;
import util.JDBCDataSource;

public class HospitalModule {

	public void add(HospitalBean bean) {
		Connection con = null;
		try {
			con = JDBCDataSource.getConnection();

			System.out.println("add ke andera gya");
			con.setAutoCommit(false);
			System.out.println("=============================)");

			PreparedStatement ps = con.prepareStatement("INSERT INTO hospital VALUES(?, ?, ?, ?, ?)");

			System.out.println("query rum===============)");

			ps.setInt(1, bean.getPatientId());
			ps.setString(2, bean.getName());
			ps.setInt(3, bean.getAge());
			ps.setString(4, bean.getBloodgroup());
			ps.setString(5, bean.getDisease());
			System.out.println(bean.getPatientId());

			System.out.println(bean.getPatientId());
			int i = ps.executeUpdate();
			System.out.println("========================)excute update");
			con.commit();

			System.out.println(i + "done");

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollback(con);

		} finally {
			JDBCDataSource.closeConnection(con);
		}

	}
	// ----------------------------------update-----------------------------------------------------------------

	public void update(HospitalBean bean) {
		Connection con = null;
		try {
			con = JDBCDataSource.getConnection();
			con.setAutoCommit(false);

			PreparedStatement ps = con
					.prepareStatement("update  Hospital set name =?, age = ?, disease = ? where patientId = ?");

			ps.setString(1, bean.getName());
			ps.setInt(2, bean.getAge());

			ps.setString(3, bean.getDisease());
			ps.setInt(4, bean.getPatientId());

			int i = ps.executeUpdate();

			System.out.println("record update succesfully");

			con.commit();

		} catch (Exception e) {
			JDBCDataSource.trnRollback(con);

		} finally {
			JDBCDataSource.closeConnection(con);
		}

	}

	// -----------------------------------------------DEleTE------------------------------------------------------------

	public void delete(int patientId) {
		Connection con = null;
		try {
			con = JDBCDataSource.getConnection();
			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement("delete from Hospital where patientId = ?");
			ps.setInt(1, patientId);

			int i = ps.executeUpdate();

			System.out.println("record deleteed succesfully");

			con.commit();

		} catch (Exception e) {
			JDBCDataSource.trnRollback(con);

		} finally {
			JDBCDataSource.closeConnection(con);
		}

	}

	// ---------------------------------FIndBYPK-------------------------------------------------------------

}
