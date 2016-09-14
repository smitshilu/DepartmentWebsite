package login;

import interfaces.Login;
import database.DAO;

public class LoginCheck {
	
	Login login;

	public LoginCheck(String netid) {
		
		DAO dao = new DAO();
		String type = dao.LoginType(netid);
		
		if(type.equals("1")) {
			login = new StudentLogin();
		}
		else if(type.equals("2")) {
			login = new FacultyLogin();
		}
		else {
			login = new StaffLogin();
		}
		
	}
	
	public int LoginDetailsCheck(String netid, String password) throws Exception {
		return login.authenticateLogin(netid, password);
	}
	

}
