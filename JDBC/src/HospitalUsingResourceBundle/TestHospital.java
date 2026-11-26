package HospitalUsingResourceBundle;
import java.util.ResourceBundle;



public class TestHospital {
	public static void main(String[] args) {
		//testadd();
		testUpdate();
		//testdelete();
	}

	private static void testdelete() {
		HospitalModule h1 = new HospitalModule();
		HospitalBean bean = new HospitalBean();
		h1.delete(1);
		
		
	}

	private static void testUpdate() {
		HospitalModule h1 = new HospitalModule();
		HospitalBean bean = new HospitalBean();
		
		bean.setPatientId(1);
		bean.setName("alok");
		bean.setAge(18);
		h1.update(bean);
		
	}

	private static void testadd() {
		HospitalModule h1 = new HospitalModule();
		HospitalBean bean = new HospitalBean();
		
		bean.setPatientId(1);
		bean.setName("alok");
		bean.setAge(18);
		bean.setBloodgroup("o+");
		bean.setDisease("pagalpan");
		h1.add(bean);
		
		
	}

}
