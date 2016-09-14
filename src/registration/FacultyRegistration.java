package registration;

import database.DAO;
import interfaces.Registration;

public class FacultyRegistration implements Registration {

	@Override
	public boolean addUser(String netid, String password, String role,
			String fname, String lname, String email, String year, String program,
			String major) throws Exception {

		DAO dao = new DAO();
		if (!dao.checkNetIDAvailble(netid)) {
			if (dao.addUserFaculty(netid, password, role, fname, lname, email)) {
				return true;
			}
		} else {
			return false;
		}

		return false;
	}

}
