package login;

import database.DAO;
import interfaces.Login;

public class StaffLogin implements Login {

	@Override
	public int authenticateLogin(String netid, String password)
			throws Exception {

		DAO dao = new DAO();

		if (dao.LoginAuth(netid, password)) {
			return 3;
		} else {
			return 0;
		}
	}
}
