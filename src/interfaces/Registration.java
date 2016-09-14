package interfaces;

public interface Registration {

	public boolean addUser(String netid, String password, String role,
			String fname, String lname, String email, String year, String program, String major)
			throws Exception;

}
