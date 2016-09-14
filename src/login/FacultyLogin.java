package login;

import database.DAO;
import interfaces.Login;

public class FacultyLogin implements Login {

	@Override
	public int authenticateLogin(String netid, String password)
			throws Exception {
		DAO dao = new DAO();

		if (dao.LoginAuth(netid, password)) {
			return 2;
		} else {
			return 0;
		}
	}

}
