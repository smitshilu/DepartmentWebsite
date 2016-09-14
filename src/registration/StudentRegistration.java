package registration;

import database.DAO;
import interfaces.Registration;

public class StudentRegistration implements Registration {

	@Override
	public boolean addUser(String netid, String password, String role,
			String fname, String lname, String email, String year, String program, String major)
			throws Exception {
		
		DAO dao = new DAO();
		
		System.out.println("3 "+password);
		
		if(dao.addUserStudent(netid, password, role, fname, lname, year, program, major)) {
			return true;
		}
		
		return false;
	}

}
