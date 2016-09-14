package registration;

import database.DAO;
import interfaces.Registration;

public class StaffRegistration implements Registration {

	@Override
	public boolean addUser(String netid, String password, String role,
			String fname, String lname, String email, String year, String program, String major)
			throws Exception {
		
		DAO dao = new DAO();
		if(dao.addUserStaff(netid, password, role, fname, lname)) {
			return true;
		}
		
		return false;
	}

}
