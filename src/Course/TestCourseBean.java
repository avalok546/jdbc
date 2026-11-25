package Course;

import java.beans.beancontext.BeanContext;
import java.sql.SQLException;

import jdbc.testUpdate;
import jdbc.testdelete;

public class TestCourseBean {

	public static void main(String[] args) throws SQLException {
		//testadd();
		//testdelete();
		//testUpdate();
		testFindByPk();
	}

	

	private static void testadd() throws SQLException {
		CourseModel m = new CourseModel();
		CourseBean c = new CourseBean();
		c.setCourseId(4);
		c.setCourseName("c course");
		c.setDuration(35);
		c.setPrice(2000.98);
		c.setLevel("hard");
		
		m.add(c);
		
		

	}

	private static void testdelete() throws SQLException {
		CourseModel m = new CourseModel();
	
		m.delete(8);

	}
	private static void testUpdate() throws SQLException {
		CourseModel m = new CourseModel();
		CourseBean c = new CourseBean();
		
		c.setCourseName("react");
		c.setCourseId(1);
		
		m.update(c);
	
		
	}
	private static void	testFindByPk() throws SQLException {
		CourseModel m = new CourseModel();
		CourseBean c = new CourseBean();
		c = m.findByPk(1);
		System.out.println(c.getCourseId());
		System.out.println(c.getCourseName());
		
		
	}

}
