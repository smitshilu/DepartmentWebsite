package Junit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import database.DAO;
import junit.framework.TestCase;

public class LoginTest extends TestCase {

	static String uname = "";
	static String pass = "";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		uname = "ss665414";
		pass = "1234";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testLoginAuth() {
		DAO dao = new DAO();
		boolean temp = dao.LoginAuth("ss665414", "123");
		System.out.println(temp);
		Assert.assertTrue(temp);
	}

}
