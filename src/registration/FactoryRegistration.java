package registration;

import interfaces.Registration;

public class FactoryRegistration {

	Registration registration;

	public FactoryRegistration(String role) {
		if (role.equals("student")) {
			registration = new StudentRegistration();
		} else if (role.equals("faculty")) {
			registration = new FacultyRegistration();
		} else {
			registration = new StaffRegistration();
		}
	}

	public boolean addUser(String netid, String password, String role,
			String fname, String lname, String email, String year, String program, String major)
			throws Exception {

		if (registration.addUser(netid, password, role, fname, lname, email, year,
				program, major)) {
			return true;
		}

		return false;
	}

}
